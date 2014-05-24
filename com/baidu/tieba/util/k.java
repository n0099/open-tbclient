package com.baidu.tieba.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class k {
    private static Boolean a = true;
    private static Boolean b = true;

    public static void a(String str) {
        a(13, str);
    }

    public static String a() {
        return d(13);
    }

    public static void b(String str) {
        b(13, str);
    }

    public static void c(String str) {
        a(2, str);
    }

    public static String b() {
        return d(2);
    }

    public static void c() {
        c(2);
    }

    public static void d(String str) {
        a(3, str);
    }

    public static void d() {
        c(3);
    }

    public static String e() {
        return d(3);
    }

    public static void e(String str) {
        a(4, str);
    }

    public static void f() {
        c(4);
    }

    public static String g() {
        return d(4);
    }

    private static void a(int i, String str) {
        DatabaseManager databaseManager;
        if (TbadkApplication.getCurrentAccount() != null && (databaseManager = new DatabaseManager()) != null) {
            try {
                databaseManager.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TbadkApplication.getCurrentAccount()});
                databaseManager.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{TbadkApplication.getCurrentAccount(), Integer.valueOf(i), str});
            } catch (Exception e) {
                BdLog.e("DatabaseManager", "cachData", "error = " + e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.cashData" + i, new Object[0]);
            }
        }
    }

    private static void c(int i) {
        DatabaseManager databaseManager;
        if (TbadkApplication.getCurrentAccount() != null && (databaseManager = new DatabaseManager()) != null) {
            try {
                databaseManager.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TbadkApplication.getCurrentAccount()});
            } catch (Exception e) {
                BdLog.e("DatabaseManager", "cachData", "error = " + e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.delCachData" + i, new Object[0]);
            }
        }
    }

    private static String d(int i) {
        Cursor cursor;
        String str;
        Exception e;
        Cursor cursor2;
        Cursor cursor3 = null;
        if (TbadkApplication.getCurrentAccount() == null) {
            return null;
        }
        DatabaseManager databaseManager = new DatabaseManager();
        try {
            if (databaseManager != null) {
                try {
                    cursor = databaseManager.a("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), TbadkApplication.getCurrentAccount()});
                    if (cursor != null) {
                        try {
                            str = cursor.moveToFirst() ? cursor.getString(2) : null;
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e = e2;
                                BdLog.e("DatabaseManager", "getCachData", "error = " + e.getMessage());
                                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.getCachData" + i, new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                        TiebaStatic.printDBExceptionLog(e3, "DatabaseManager.getCachData" + i + "close cursor", new Object[0]);
                                    }
                                }
                                return str;
                            }
                        } catch (Exception e4) {
                            str = null;
                            e = e4;
                        }
                    } else {
                        str = null;
                    }
                    cursor2 = null;
                } catch (Exception e5) {
                    cursor = null;
                    str = null;
                    e = e5;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            cursor3.close();
                        } catch (Exception e6) {
                            TiebaStatic.printDBExceptionLog(e6, "DatabaseManager.getCachData" + i + "close cursor", new Object[0]);
                        }
                    }
                    throw th;
                }
            } else {
                cursor2 = null;
                str = null;
            }
            if (0 != 0) {
                try {
                    cursor2.close();
                } catch (Exception e7) {
                    TiebaStatic.printDBExceptionLog(e7, "DatabaseManager.getCachData" + i + "close cursor", new Object[0]);
                }
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void b(int i, String str) {
        str = (str == null || str.length() == 0) ? "0" : "0";
        DatabaseManager databaseManager = new DatabaseManager();
        if (databaseManager != null) {
            try {
                databaseManager.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), str});
            } catch (Exception e) {
                BdLog.e("DatabaseManager", "cachData", "error = " + e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.delCachData" + i, new Object[0]);
            }
        }
    }

    public static ArrayList<String> h() {
        return e(0);
    }

    public static ArrayList<String> i() {
        return e(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0014 A[EXC_TOP_SPLITTER, LOOP:0: B:55:0x0014->B:60:0x0014, LOOP_START, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ArrayList<String> e(int i) {
        Cursor a2;
        Cursor cursor;
        Cursor cursor2 = null;
        DatabaseManager databaseManager = new DatabaseManager();
        ArrayList<String> arrayList = new ArrayList<>();
        if (databaseManager != null) {
            try {
                try {
                    switch (i) {
                        case 0:
                            a2 = databaseManager.a("select * from search_data order by time desc limit 10", (String[]) null);
                            if (a2 != null) {
                                while (a2.moveToNext()) {
                                    try {
                                        String string = a2.getString(0);
                                        if (string != null && string.length() > 0) {
                                            arrayList.add(string);
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        cursor2 = a2;
                                        BdLog.e("DatabaseManager", "getAllSearchData", "error = " + e.getMessage());
                                        TiebaStatic.printDBExceptionLog(e, "DatabaseManager.getAllSearchData", new Object[0]);
                                        if (cursor2 != null) {
                                            try {
                                                cursor2.close();
                                            } catch (Exception e2) {
                                                TiebaStatic.printDBExceptionLog(e2, "DatabaseManager.getAllSearchData close cursor", new Object[0]);
                                            }
                                        }
                                        return arrayList;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor2 = a2;
                                        break;
                                    }
                                }
                                a2.close();
                            }
                            cursor = null;
                            break;
                        case 1:
                            a2 = databaseManager.a("select * from search_post_data order by time desc limit 10", (String[]) null);
                            if (a2 != null) {
                            }
                            cursor = null;
                            break;
                        default:
                            a2 = null;
                            if (a2 != null) {
                            }
                            cursor = null;
                            break;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception e4) {
                    TiebaStatic.printDBExceptionLog(e4, "DatabaseManager.getAllSearchData close cursor", new Object[0]);
                }
            }
            throw th;
        }
        cursor = null;
        if (0 != 0) {
            try {
                cursor.close();
            } catch (Exception e5) {
                TiebaStatic.printDBExceptionLog(e5, "DatabaseManager.getAllSearchData close cursor", new Object[0]);
            }
        }
        return arrayList;
    }

    public static void f(String str) {
        c(0, str);
    }

    public static void g(String str) {
        c(1, str);
    }

    private static void c(int i, String str) {
        DatabaseManager databaseManager = new DatabaseManager();
        if (databaseManager != null && str != null) {
            try {
                Date date = new Date();
                switch (i) {
                    case 0:
                        databaseManager.a("delete from search_data where key=?", (Object[]) new String[]{str});
                        databaseManager.a("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkApplication.getCurrentAccount(), Long.valueOf(date.getTime())});
                        break;
                    case 1:
                        databaseManager.a("delete from search_post_data where key=?", (Object[]) new String[]{str});
                        databaseManager.a("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkApplication.getCurrentAccount(), Long.valueOf(date.getTime())});
                        break;
                }
            } catch (Exception e) {
                BdLog.e("DatabaseManager", "saveSearchData", "error = " + e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.saveOneSearchData", new Object[0]);
            }
        }
    }

    public static void j() {
        a(0);
    }

    public static void k() {
        a(1);
    }

    public static void a(int i) {
        DatabaseManager databaseManager = new DatabaseManager();
        if (databaseManager != null) {
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
                BdLog.e("DatabaseManager", "delAllSearchData", "error = " + e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.delAllSearchData", new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<MarkData> l() {
        Cursor cursor;
        Throwable th;
        Exception e;
        Cursor cursor2;
        if (TbadkApplication.getCurrentAccount() == null) {
            return null;
        }
        DatabaseManager databaseManager = new DatabaseManager();
        ArrayList<MarkData> arrayList = new ArrayList<>();
        if (databaseManager != null) {
            try {
                cursor = databaseManager.a("select * from mark_data where account=? order by time desc", new String[]{TbadkApplication.getCurrentAccount()});
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
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
                                BdLog.e("DatabaseManager", "getAllMarkData", "error = " + e.getMessage());
                                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.getAllMarkData", new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                        TiebaStatic.printDBExceptionLog(e3, "DatabaseManager.getAllMarkData close cursor", new Object[0]);
                                    }
                                }
                                BdLog.i("DatabaseManager", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
                                return arrayList;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e4) {
                                    TiebaStatic.printDBExceptionLog(e4, "DatabaseManager.getAllMarkData close cursor", new Object[0]);
                                }
                            }
                            throw th;
                        }
                    }
                    cursor.close();
                }
                a((Boolean) false);
                cursor2 = null;
            } catch (Exception e5) {
                cursor = null;
                e = e5;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                if (cursor != null) {
                }
                throw th;
            }
        } else {
            cursor2 = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e6) {
                TiebaStatic.printDBExceptionLog(e6, "DatabaseManager.getAllMarkData close cursor", new Object[0]);
            }
        }
        BdLog.i("DatabaseManager", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
        return arrayList;
    }

    public static void a(Boolean bool) {
        a = bool;
    }

    public static void b(Boolean bool) {
        b = bool;
    }

    public static void m() {
        if (TbadkApplication.getCurrentAccount() != null) {
            DatabaseManager databaseManager = new DatabaseManager();
            try {
                databaseManager.a("delete from setting where account=?", new Object[]{TbadkApplication.getCurrentAccount()});
                Object[] objArr = new Object[10];
                objArr[0] = TbadkApplication.getCurrentAccount();
                objArr[1] = Integer.valueOf(TbadkApplication.m252getInst().getMsgFrequency());
                objArr[2] = Integer.valueOf(TbadkApplication.m252getInst().isMsgFansOn() ? 1 : 0);
                objArr[3] = Integer.valueOf(TbadkApplication.m252getInst().isMsgReplymeOn() ? 1 : 0);
                objArr[4] = Integer.valueOf(TbadkApplication.m252getInst().isMsgAtmeOn() ? 1 : 0);
                objArr[5] = Integer.valueOf(ai.c().r());
                objArr[6] = Integer.valueOf(TbadkApplication.m252getInst().isMsgChatOn() ? 1 : 0);
                objArr[7] = Integer.valueOf(TbadkApplication.m252getInst().isNoDisturbOn() ? 1 : 0);
                objArr[8] = TbadkApplication.m252getInst().getNoDisturbStartTime();
                objArr[9] = TbadkApplication.m252getInst().getNoDisturbEndTime();
                databaseManager.a("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time) values(?,?,?,?,?,?,?,?,?,?)", objArr);
            } catch (Exception e) {
                BdLog.e("DatabaseManager", "saveDraftBox", "error = " + e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.saveSettingData", new Object[0]);
            }
        }
    }

    public static void n() {
        BdLog.i("DatabaseManager", "getSetting", TbadkApplication.getCurrentAccountName());
        if (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccount().length() <= 0 || TbadkApplication.getCurrentAccountName() == null) {
            ai.c().b(0);
            return;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor a2 = new DatabaseManager().a("select * from setting where account=?", new String[]{TbadkApplication.getCurrentAccount()});
                if (a2 != null && a2.moveToFirst()) {
                    ai.c().b(a2.getInt(1));
                    if (a2.getInt(2) == 0) {
                        ai.c().i(false);
                    } else {
                        ai.c().i(true);
                    }
                    if (a2.getInt(3) == 0) {
                        ai.c().l(false);
                    } else {
                        ai.c().l(true);
                    }
                    if (a2.getInt(4) == 0) {
                        ai.c().j(false);
                    } else {
                        ai.c().j(true);
                    }
                    ai.c().a(a2.getInt(5));
                    if (a2.getInt(6) == 0) {
                        ai.c().m(false);
                    } else {
                        ai.c().m(true);
                    }
                    if (a2.getInt(7) == 0) {
                        ai.c().g(false);
                    } else {
                        ai.c().g(true);
                    }
                    String string = a2.getString(8);
                    if (TextUtils.isEmpty(string)) {
                        ai.c().h(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    } else {
                        ai.c().h(string);
                    }
                    String string2 = a2.getString(9);
                    if (TextUtils.isEmpty(string2)) {
                        ai.c().i(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    } else {
                        ai.c().i(string2);
                    }
                } else {
                    ai.c().b(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
                    ai.c().i(true);
                    ai.c().l(true);
                    ai.c().j(true);
                    ai.c().f(true);
                    ai.c().h(false);
                    ai.c().m(true);
                    ai.c().g(false);
                    ai.c().h(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    ai.c().i(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                }
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Exception e) {
                        TiebaStatic.printDBExceptionLog(e, "DatabaseManager.getSettingData close cursor", new Object[0]);
                    }
                }
            } catch (Exception e2) {
                BdLog.e("DatabaseManager", "getDraftBox", "error = " + e2.getMessage());
                TiebaStatic.printDBExceptionLog(e2, "DatabaseManager.getSettingData", new Object[0]);
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                        TiebaStatic.printDBExceptionLog(e3, "DatabaseManager.getSettingData close cursor", new Object[0]);
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                    TiebaStatic.printDBExceptionLog(e4, "DatabaseManager.getSettingData close cursor", new Object[0]);
                }
            }
            throw th;
        }
    }

    public static void h(String str) {
        DatabaseManager databaseManager;
        if (str != null && (databaseManager = new DatabaseManager()) != null) {
            try {
                databaseManager.a("delete from cash_data where account=?", (Object[]) new String[]{str});
                databaseManager.a("delete from mark_data where account=?", (Object[]) new String[]{str});
                databaseManager.a("delete from draft_box where account=?", new Object[]{str});
                databaseManager.a("delete from account_data where id=?", new Object[]{str});
                databaseManager.a("delete from setting where account=?", new Object[]{str});
            } catch (Exception e) {
                BdLog.e("DatabaseManager", "deleteAccountAllInfo", e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.deleteAccountAllInfo", new Object[0]);
            }
        }
    }

    public static boolean a(String str, int i) {
        DatabaseManager databaseManager = new DatabaseManager();
        if (databaseManager != null) {
            try {
                databaseManager.a("delete from cash_data where type=?", (Object[]) new String[]{String.valueOf(i)});
                return databaseManager.a("Insert into cash_data(type ,account ,data ) values(?,?,?)", (Object[]) new String[]{String.valueOf(i), "", str}).booleanValue();
            } catch (Exception e) {
                BdLog.e("DatabaseManager", "cashHostspot", "error = " + e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.cashNoAccountData" + i, new Object[0]);
                return false;
            }
        }
        return false;
    }

    public static String b(int i) {
        Cursor cursor;
        Exception e;
        String str;
        Cursor cursor2;
        Cursor cursor3 = null;
        DatabaseManager databaseManager = new DatabaseManager();
        try {
            if (databaseManager != null) {
                try {
                    cursor = databaseManager.a("select * from cash_data where type=? ", new String[]{String.valueOf(i)});
                    if (cursor != null) {
                        try {
                            str = cursor.moveToFirst() ? cursor.getString(2) : null;
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e = e2;
                                BdLog.e("DatabaseManager", "getHotspot", "error = " + e.getMessage());
                                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.getNoAccountData" + i, new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                        TiebaStatic.printDBExceptionLog(e3, "DatabaseManager.getNoAccountData" + i + "close cursor", new Object[0]);
                                    }
                                }
                                return str;
                            }
                        } catch (Exception e4) {
                            str = null;
                            e = e4;
                        }
                    } else {
                        str = null;
                    }
                    cursor2 = null;
                } catch (Exception e5) {
                    cursor = null;
                    e = e5;
                    str = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            cursor3.close();
                        } catch (Exception e6) {
                            TiebaStatic.printDBExceptionLog(e6, "DatabaseManager.getNoAccountData" + i + "close cursor", new Object[0]);
                        }
                    }
                    throw th;
                }
            } else {
                str = null;
                cursor2 = null;
            }
            if (0 != 0) {
                try {
                    cursor2.close();
                } catch (Exception e7) {
                    TiebaStatic.printDBExceptionLog(e7, "DatabaseManager.getNoAccountData" + i + "close cursor", new Object[0]);
                }
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
