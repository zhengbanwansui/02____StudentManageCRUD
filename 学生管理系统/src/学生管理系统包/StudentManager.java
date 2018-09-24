package ѧ������ϵͳ��;
import java.sql.*;
import java.util.Scanner;
import java.*;
public class StudentManager{
	static void addStu(Connection conn,String temp_name,int temp_num,int temp_mark) throws SQLException{
		String temp_str = "INSERT INTO tab1(id,name,num,mark) VALUES (?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(temp_str);
		pstmt.setNull(1,Types.INTEGER);
		pstmt.setString(2,temp_name);
		pstmt.setInt(3,temp_num);
		pstmt.setInt(4,temp_mark);
		int t = pstmt.executeUpdate(); // ִ�и���
		System.out.println("[[[" + t + "]]]");
		pstmt.close();
	}
	static void delStu(Connection conn,String temp_name) throws SQLException{
		String temp_str = "DELETE FROM tab1 where name = ?";
		PreparedStatement pstmt = conn.prepareStatement(temp_str);
		pstmt.setString(1,temp_name);
		int t = pstmt.executeUpdate(); // ִ�и���
		System.out.println("[[[" + t + "]]]");
		pstmt.close();
	}
	static void chgeStu(Connection conn,String temp_name,int temp_num,int temp_mark) throws SQLException{
		String temp_str = "UPDATE tab1 set num=? ,mark=? where name = ?";
		PreparedStatement pstmt = conn.prepareStatement(temp_str);
		pstmt.setInt(1,temp_num);
		pstmt.setInt(2,temp_mark);
		pstmt.setString(3,temp_name);
		int t = pstmt.executeUpdate(); // ִ�и���
		System.out.println("[[[" + t + "]]]");
		pstmt.close();
	}
	static void findStu(Connection conn,String temp_name) throws SQLException{
		String temp_str = "select * from tab1 where name=?";
		PreparedStatement pstmt = conn.prepareStatement(temp_str);
		pstmt.setString(1,temp_name);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
		System.out.println(rs.getInt(1) + "#" + rs.getString(2) + "#" + rs.getInt(3) + "#" + rs.getInt(4));
		}
		pstmt.close();
	}
	static void showStu(Connection conn) throws SQLException{
		String temp_str = "select * from tab1";
		PreparedStatement pstmt = conn.prepareStatement(temp_str);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
		System.out.println(rs.getInt(1) + "#" + rs.getString(2) + "#" + rs.getInt(3) + "#" + rs.getInt(4));
		}
		pstmt.close();
	}
	public static void main(String[] args) {
			//����������
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1){e1.printStackTrace();}
			try {
				//��������
				String uri = "jdbc:mysql://localhost:3306/javasjk?useSSL=false&serverTimezone=GMT%2B8&amp";
				Connection conn = DriverManager.getConnection(uri,"root","1234");
				//��ʼִ���������
				//addStu(conn,"xyx",171201202,120);
				//delStu(conn,"xyx");
				//chgeStu(conn,"�Ž���",171201202,100);
				//findStu(conn,"�Ž���");
				//showStu(conn);
				Scanner scanner = new Scanner(System.in);
				for(;;) {
					System.out.println("----------------�Ž�����ѧ������ϵͳ�������������ָ��----------------");
					System.out.println("1   ��   2ɾ   3��   4��   5�鿴ȫ��");
					int swc = scanner.nextInt();
					switch(swc) {
					case 1:
						System.out.println("����ѧ����Ϣ�����Դ�����ѧ����������ѧ�ţ�����");
						String temp_name = scanner.next();
						int temp_num = scanner.nextInt();
						int temp_mark = scanner.nextInt();
						addStu(conn,temp_name,temp_num,temp_mark);
						break;
					case 2:
						System.out.println("ɾ��ѧ����Ϣ��������ѧ��������");
						String temp_name1 = scanner.next();
						delStu(conn,temp_name1);
						break;
					case 3:
						System.out.println("�޸�ѧ����Ϣ��������ѧ�����������޸ĺ��ѧ�źͷ���");
						String temp_name3 = scanner.next();
						int temp_num1 = scanner.nextInt();
						int temp_mark1 = scanner.nextInt();
						chgeStu(conn,temp_name3,temp_num1,temp_mark1);
						break;
					case 4:
						System.out.println("��ѯѧ����Ϣ��������ѧ��������");
						String temp_name2 = scanner.next();
						findStu(conn,temp_name2);
						break;
					case 5:
						System.out.println("��ʾ����ѧ����Ϣ��");
						showStu(conn);
						break;
					default:
						System.out.println("������1��5�����֣�лл");
					}
				}
			}catch(Exception e){e.printStackTrace();}
	}
}