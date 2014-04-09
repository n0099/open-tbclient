package com.baidu.tieba.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public final class k {
    private static Boolean a = true;
    private static Boolean b = true;

    public static void a(String str) {
        a(13, str);
    }

    public static String a() {
        return c(13);
    }

    public static void b(String str) {
        try {
            new DatabaseManager().a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(13), (str == null || str.length() == 0) ? "0" : "0"});
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("DatabaseManager", "cachData", "error = " + e.getMessage());
            TiebaStatic.a(e, new StringBuilder("DatabaseManager.delCachData13").toString(), new Object[0]);
        }
    }

    public static void c(String str) {
        a(2, str);
    }

    public static String b() {
        return c(2);
    }

    public static void c() {
        b(2);
    }

    public static void d(String str) {
        a(3, str);
    }

    public static void d() {
        b(3);
    }

    public static String e() {
        return c(3);
    }

    public static void e(String str) {
        a(4, str);
    }

    public static void f() {
        b(4);
    }

    public static String g() {
        return c(4);
    }

    private static void a(int i, String str) {
        if (TbadkApplication.E() != null) {
            DatabaseManager databaseManager = new DatabaseManager();
            try {
                databaseManager.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TbadkApplication.E()});
                databaseManager.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{TbadkApplication.E(), Integer.valueOf(i), str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseManager", "cachData", "error = " + e.getMessage());
                TiebaStatic.a(e, "DatabaseManager.cashData" + i, new Object[0]);
            }
        }
    }

    private static void b(int i) {
        if (TbadkApplication.E() != null) {
            try {
                new DatabaseManager().a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TbadkApplication.E()});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseManager", "cachData", "error = " + e.getMessage());
                TiebaStatic.a(e, "DatabaseManager.delCachData" + i, new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String c(int i) {
        Cursor cursor;
        Throwable th;
        if (TbadkApplication.E() != null) {
            try {
                cursor = new DatabaseManager().a("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), TbadkApplication.E()});
                if (cursor != null) {
                    try {
                        try {
                            r0 = cursor.moveToFirst() ? cursor.getString(2) : null;
                            cursor.close();
                        } catch (Exception e) {
                            e = e;
                            com.baidu.adp.lib.util.f.b("DatabaseManager", "getCachData", "error = " + e.getMessage());
                            TiebaStatic.a(e, "DatabaseManager.getCachData" + i, new Object[0]);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e2) {
                                    TiebaStatic.a(e2, "DatabaseManager.getCachData" + i + "close cursor", new Object[0]);
                                }
                            }
                            return r0;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                TiebaStatic.a(e3, "DatabaseManager.getCachData" + i + "close cursor", new Object[0]);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                if (cursor != null) {
                }
                throw th;
            }
        }
        return r0;
    }

    public static ArrayList<String> h() {
        return d(0);
    }

    public static ArrayList<String> i() {
        return d(1);
    }

    private static ArrayList<String> d(int i) {
        Cursor cursor = null;
        DatabaseManager databaseManager = new DatabaseManager();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            try {
                switch (i) {
                    case 0:
                        cursor = databaseManager.a("select * from search_data order by time desc limit 10", (String[]) null);
                        break;
                    case 1:
                        cursor = databaseManager.a("select * from search_post_data order by time desc limit 10", (String[]) null);
                        break;
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        if (string != null && string.length() > 0) {
                            arrayList.add(string);
                        }
                    }
                    cursor.close();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseManager", "getAllSearchData", "error = " + e.getMessage());
                TiebaStatic.a(e, "DatabaseManager.getAllSearchData", new Object[0]);
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                        TiebaStatic.a(e2, "DatabaseManager.getAllSearchData close cursor", new Object[0]);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                    TiebaStatic.a(e3, "DatabaseManager.getAllSearchData close cursor", new Object[0]);
                }
            }
            throw th;
        }
    }

    public static void f(String str) {
        b(0, str);
    }

    public static void g(String str) {
        b(1, str);
    }

    private static void b(int i, String str) {
        DatabaseManager databaseManager = new DatabaseManager();
        if (str != null) {
            try {
                Date date = new Date();
                switch (i) {
                    case 0:
                        databaseManager.a("delete from search_data where key=?", (Object[]) new String[]{str});
                        databaseManager.a("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkApplication.E(), Long.valueOf(date.getTime())});
                        break;
                    case 1:
                        databaseManager.a("delete from search_post_data where key=?", (Object[]) new String[]{str});
                        databaseManager.a("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkApplication.E(), Long.valueOf(date.getTime())});
                        break;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseManager", "saveSearchData", "error = " + e.getMessage());
                TiebaStatic.a(e, "DatabaseManager.saveOneSearchData", new Object[0]);
            }
        }
    }

    public static void j() {
        e(0);
    }

    public static void k() {
        e(1);
    }

    private static void e(int i) {
        DatabaseManager databaseManager = new DatabaseManager();
        try {
            switch (i) {
                case 0:
                    databaseManager.a("delete from search_data");
                    break;
                case 1:
                    databaseManager.a("delete from search_post_data");
                    break;
                default:
                    return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("DatabaseManager", "delAllSearchData", "error = " + e.getMessage());
            TiebaStatic.a(e, "DatabaseManager.delAllSearchData", new Object[0]);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x012d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tbadk.core.util.DatabaseManager] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<MarkData> l() {
        Throwable th;
        Cursor cursor;
        Exception e;
        if (TbadkApplication.E() == null) {
            return null;
        }
        ?? databaseManager = new DatabaseManager();
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            try {
                cursor = databaseManager.a("select * from mark_data where account=? order by time desc", new String[]{TbadkApplication.E()});
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            MarkData markData = new MarkData();
                            markData.setId(cursor.getString(0));
                            markData.setFloor(cursor.getInt(1));
                            markData.setTime(cursor.getInt(2));
                            markData.setTitle(cursor.getString(3));
                            markData.setSequence(Boolean.valueOf(cursor.getInt(4) == 1));
                            markData.setHostMode(cursor.getInt(5) == 1);
                            markData.setPostId(cursor.getString(6));
                            markData.setAccount(cursor.getString(7));
                            markData.setAuthorName(cursor.getString(8));
                            markData.setReplyNum(cursor.getInt(9));
                            markData.setSubPost(cursor.getInt(10));
                            markData.setForumName(cursor.getString(11));
                            markData.setForumId(cursor.getString(12));
                            markData.setThreadId(cursor.getString(13));
                            arrayList.add(markData);
                        } catch (Exception e2) {
                            e = e2;
                            com.baidu.adp.lib.util.f.b("DatabaseManager", "getAllMarkData", "error = " + e.getMessage());
                            TiebaStatic.a(e, "DatabaseManager.getAllMarkData", new Object[0]);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    TiebaStatic.a(e3, "DatabaseManager.getAllMarkData close cursor", new Object[0]);
                                }
                            }
                            com.baidu.adp.lib.util.f.a("DatabaseManager", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
                            return arrayList;
                        }
                    }
                    cursor.close();
                }
                a = false;
            } catch (Throwable th2) {
                th = th2;
                if (databaseManager != 0) {
                    try {
                        databaseManager.close();
                    } catch (Exception e4) {
                        TiebaStatic.a(e4, "DatabaseManager.getAllMarkData close cursor", new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            cursor = null;
            e = e5;
        } catch (Throwable th3) {
            databaseManager = 0;
            th = th3;
            if (databaseManager != 0) {
            }
            throw th;
        }
        com.baidu.adp.lib.util.f.a("DatabaseManager", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
        return arrayList;
    }

    public static void a(Boolean bool) {
        b = bool;
    }

    public static void m() {
        if (TbadkApplication.E() != null) {
            DatabaseManager databaseManager = new DatabaseManager();
            try {
                databaseManager.a("delete from setting where account=?", new Object[]{TbadkApplication.E()});
                Object[] objArr = new Object[10];
                objArr[0] = TbadkApplication.E();
                objArr[1] = Integer.valueOf(TbadkApplication.j().ai());
                objArr[2] = Integer.valueOf(TbadkApplication.j().am() ? 1 : 0);
                objArr[3] = Integer.valueOf(TbadkApplication.j().ak() ? 1 : 0);
                objArr[4] = Integer.valueOf(TbadkApplication.j().aj() ? 1 : 0);
                com.baidu.tieba.p.c();
                objArr[5] = Integer.valueOf(com.baidu.tieba.p.n());
                objArr[6] = Integer.valueOf(TbadkApplication.j().ag() ? 1 : 0);
                objArr[7] = Integer.valueOf(TbadkApplication.j().as() ? 1 : 0);
                objArr[8] = TbadkApplication.j().at();
                objArr[9] = TbadkApplication.j().au();
                databaseManager.a("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time) values(?,?,?,?,?,?,?,?,?,?)", objArr);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseManager", "saveDraftBox", "error = " + e.getMessage());
                TiebaStatic.a(e, "DatabaseManager.saveSettingData", new Object[0]);
            }
        }
    }

    public static void n() {
        com.baidu.adp.lib.util.f.a("DatabaseManager", "getSetting", TbadkApplication.O());
        if (TbadkApplication.E() == null || TbadkApplication.E().length() <= 0 || TbadkApplication.O() == null) {
            com.baidu.tieba.p.c().b(0);
            return;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor a2 = new DatabaseManager().a("select * from setting where account=?", new String[]{TbadkApplication.E()});
                if (a2 != null && a2.moveToFirst()) {
                    com.baidu.tieba.p.c().b(a2.getInt(1));
                    if (a2.getInt(2) == 0) {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.i(false);
                    } else {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.i(true);
                    }
                    if (a2.getInt(3) == 0) {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.l(false);
                    } else {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.l(true);
                    }
                    if (a2.getInt(4) == 0) {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.j(false);
                    } else {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.j(true);
                    }
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.a(a2.getInt(5));
                    if (a2.getInt(6) == 0) {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.m(false);
                    } else {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.m(true);
                    }
                    if (a2.getInt(7) == 0) {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.g(false);
                    } else {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.g(true);
                    }
                    String string = a2.getString(8);
                    if (TextUtils.isEmpty(string)) {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.h("23:00");
                    } else {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.h(string);
                    }
                    String string2 = a2.getString(9);
                    if (TextUtils.isEmpty(string2)) {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.i("09:00");
                    } else {
                        com.baidu.tieba.p.c();
                        com.baidu.tieba.p.i(string2);
                    }
                } else {
                    com.baidu.tieba.p.c().b(300);
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.i(true);
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.l(true);
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.j(true);
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.f(true);
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.h(false);
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.m(true);
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.g(false);
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.h("23:00");
                    com.baidu.tieba.p.c();
                    com.baidu.tieba.p.i("09:00");
                }
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Exception e) {
                        TiebaStatic.a(e, "DatabaseManager.getSettingData close cursor", new Object[0]);
                    }
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b("DatabaseManager", "getDraftBox", "error = " + e2.getMessage());
                TiebaStatic.a(e2, "DatabaseManager.getSettingData", new Object[0]);
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                        TiebaStatic.a(e3, "DatabaseManager.getSettingData close cursor", new Object[0]);
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                    TiebaStatic.a(e4, "DatabaseManager.getSettingData close cursor", new Object[0]);
                }
            }
            throw th;
        }
    }

    public static void h(String str) {
        if (str != null) {
            DatabaseManager databaseManager = new DatabaseManager();
            try {
                databaseManager.a("delete from cash_data where account=?", (Object[]) new String[]{str});
                databaseManager.a("delete from mark_data where account=?", (Object[]) new String[]{str});
                databaseManager.a("delete from draft_box where account=?", new Object[]{str});
                databaseManager.a("delete from account_data where id=?", new Object[]{str});
                databaseManager.a("delete from setting where account=?", new Object[]{str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseManager", "deleteAccountAllInfo", e.getMessage());
                TiebaStatic.a(e, "DatabaseManager.deleteAccountAllInfo", new Object[0]);
            }
        }
    }

    public static boolean a(String str, int i) {
        DatabaseManager databaseManager = new DatabaseManager();
        try {
            databaseManager.a("delete from cash_data where type=?", (Object[]) new String[]{String.valueOf(7)});
            return databaseManager.a("Insert into cash_data(type ,account ,data ) values(?,?,?)", (Object[]) new String[]{String.valueOf(7), "", str}).booleanValue();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("DatabaseManager", "cashHostspot", "error = " + e.getMessage());
            TiebaStatic.a(e, new StringBuilder("DatabaseManager.cashNoAccountData7").toString(), new Object[0]);
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0097 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x001a */
    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(int i) {
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        cursor2 = null;
        String str = 0;
        try {
            try {
                cursor = new DatabaseManager().a("select * from cash_data where type=? ", new String[]{String.valueOf(7)});
                if (cursor != null) {
                    try {
                        cursor2 = cursor.moveToFirst() ? cursor.getString(2) : null;
                        cursor.close();
                        str = cursor2;
                    } catch (Exception e) {
                        e = e;
                        com.baidu.adp.lib.util.f.b("DatabaseManager", "getHotspot", "error = " + e.getMessage());
                        TiebaStatic.a(e, new StringBuilder("DatabaseManager.getNoAccountData7").toString(), new Object[0]);
                        str = cursor2;
                        if (cursor != null) {
                            try {
                                cursor.close();
                                str = cursor2;
                            } catch (Exception e2) {
                                TiebaStatic.a(e2, "DatabaseManager.getNoAccountData7close cursor", new Object[0]);
                                str = cursor2;
                            }
                        }
                        return str;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        cursor2.close();
                    } catch (Exception e3) {
                        TiebaStatic.a(e3, "DatabaseManager.getNoAccountData7close cursor", new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
        return str;
    }
}
