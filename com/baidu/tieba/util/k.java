package com.baidu.tieba.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
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
        a(4, str);
    }

    public static void d() {
        c(4);
    }

    public static String e() {
        return d(4);
    }

    private static void a(int i, String str) {
        if (TbadkApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.c b2 = com.baidu.tbadk.j.a().b();
            b2.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TbadkApplication.getCurrentAccount()});
            b2.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{TbadkApplication.getCurrentAccount(), Integer.valueOf(i), str});
        }
    }

    private static void c(int i) {
        if (TbadkApplication.getCurrentAccount() != null) {
            com.baidu.tbadk.j.a().b().a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TbadkApplication.getCurrentAccount()});
        }
    }

    private static String d(int i) {
        Cursor cursor;
        Throwable th;
        String str = null;
        if (TbadkApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.c b2 = com.baidu.tbadk.j.a().b();
            try {
                cursor = b2.a("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), TbadkApplication.getCurrentAccount()});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                str = cursor.getString(2);
                            }
                        } catch (Exception e) {
                            e = e;
                            b2.a(e, "getCachData");
                            com.baidu.adp.lib.e.a.a(cursor);
                            return str;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.e.a.a(cursor);
                        throw th;
                    }
                }
                com.baidu.adp.lib.e.a.a(cursor);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                com.baidu.adp.lib.e.a.a(cursor);
                throw th;
            }
        }
        return str;
    }

    private static void b(int i, String str) {
        com.baidu.tbadk.j.a().b().a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
    }

    public static ArrayList<String> f() {
        return e(0);
    }

    public static ArrayList<String> g() {
        return e(1);
    }

    private static ArrayList<String> e(int i) {
        Cursor cursor;
        Throwable th;
        Exception e;
        Cursor cursor2 = null;
        com.baidu.adp.base.a.c b2 = com.baidu.tbadk.j.a().b();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            switch (i) {
                case 0:
                    cursor = b2.a("select * from search_data order by time desc limit 10", (String[]) null);
                    break;
                case 1:
                    cursor2 = b2.a("select * from search_post_data order by time desc limit 10", (String[]) null);
                default:
                    cursor = cursor2;
                    break;
            }
            while (cursor.moveToNext()) {
                try {
                    try {
                        String string = cursor.getString(0);
                        if (string != null && string.length() > 0) {
                            arrayList.add(string);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        b2.a(e, "getAllSearchData");
                        com.baidu.adp.lib.e.a.a(cursor);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.e.a.a(cursor);
                    throw th;
                }
            }
            com.baidu.adp.lib.e.a.a(cursor);
        } catch (Exception e3) {
            cursor = null;
            e = e3;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.e.a.a(cursor);
            throw th;
        }
        return arrayList;
    }

    public static void e(String str) {
        c(0, str);
    }

    public static void f(String str) {
        c(1, str);
    }

    private static void c(int i, String str) {
        com.baidu.adp.base.a.c b2 = com.baidu.tbadk.j.a().b();
        if (str != null) {
            Date date = new Date();
            switch (i) {
                case 0:
                    b2.a("delete from search_data where key=?", (Object[]) new String[]{str});
                    b2.a("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkApplication.getCurrentAccount(), Long.valueOf(date.getTime())});
                    return;
                case 1:
                    b2.a("delete from search_post_data where key=?", (Object[]) new String[]{str});
                    b2.a("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkApplication.getCurrentAccount(), Long.valueOf(date.getTime())});
                    return;
                default:
                    return;
            }
        }
    }

    public static void h() {
        a(0);
    }

    public static void i() {
        a(1);
    }

    public static void a(int i) {
        com.baidu.adp.base.a.c b2 = com.baidu.tbadk.j.a().b();
        switch (i) {
            case 0:
                b2.a("delete from search_data");
                return;
            case 1:
                b2.a("delete from search_post_data");
                return;
            default:
                return;
        }
    }

    public static ArrayList<MarkData> j() {
        Cursor cursor;
        Throwable th;
        Exception e;
        if (TbadkApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.c b2 = com.baidu.tbadk.j.a().b();
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            cursor = b2.a("select * from mark_data where account=? order by time desc", new String[]{TbadkApplication.getCurrentAccount()});
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
                        b2.a(e, "getAllMarkData");
                        com.baidu.adp.lib.e.a.a(cursor);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.e.a.a(cursor);
                    throw th;
                }
            }
            a((Boolean) false);
            com.baidu.adp.lib.e.a.a(cursor);
        } catch (Exception e3) {
            cursor = null;
            e = e3;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.e.a.a(cursor);
            throw th;
        }
        return arrayList;
    }

    public static void a(Boolean bool) {
        a = bool;
    }

    public static void b(Boolean bool) {
        b = bool;
    }

    public static void k() {
        if (TbadkApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.c b2 = com.baidu.tbadk.j.a().b();
            b2.a("delete from setting where account=?", new Object[]{TbadkApplication.getCurrentAccount()});
            Object[] objArr = new Object[11];
            objArr[0] = TbadkApplication.getCurrentAccount();
            objArr[1] = Integer.valueOf(TbadkApplication.m252getInst().getMsgFrequency());
            objArr[2] = Integer.valueOf(TbadkApplication.m252getInst().isMsgNewFansOn() ? 1 : 0);
            objArr[3] = Integer.valueOf(TbadkApplication.m252getInst().isMsgReplymeOn() ? 1 : 0);
            objArr[4] = Integer.valueOf(TbadkApplication.m252getInst().isMsgAtmeOn() ? 1 : 0);
            objArr[5] = Integer.valueOf(ai.c().q());
            objArr[6] = Integer.valueOf(TbadkApplication.m252getInst().isMsgChatOn() ? 1 : 0);
            objArr[7] = Integer.valueOf(TbadkApplication.m252getInst().isNoDisturbOn() ? 1 : 0);
            objArr[8] = TbadkApplication.m252getInst().getNoDisturbStartTime();
            objArr[9] = TbadkApplication.m252getInst().getNoDisturbEndTime();
            objArr[10] = Integer.valueOf(TbadkApplication.m252getInst().isMsgLightOn() ? 1 : 0);
            b2.a("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light) values(?,?,?,?,?,?,?,?,?,?,?)", objArr);
        }
    }

    public static void l() {
        if (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccount().length() <= 0 || TbadkApplication.getCurrentAccountName() == null) {
            ai.c().b(0);
            return;
        }
        com.baidu.adp.base.a.c b2 = com.baidu.tbadk.j.a().b();
        try {
            try {
                Cursor a2 = b2.a("select * from setting where account=?", new String[]{TbadkApplication.getCurrentAccount()});
                if (a2 != null && a2.moveToFirst()) {
                    ai.c().b(a2.getInt(a2.getColumnIndex("frequency")));
                    ai.c().m(a2.getInt(a2.getColumnIndex("fans_switch")) == 1);
                    if (a2.getInt(a2.getColumnIndex("reply_me_switch")) == 0) {
                        ai.c().l(false);
                    } else {
                        ai.c().l(true);
                    }
                    if (a2.getInt(a2.getColumnIndex("at_me_switch")) == 0) {
                        ai.c().j(false);
                    } else {
                        ai.c().j(true);
                    }
                    ai.c().a(a2.getInt(a2.getColumnIndex("remind_tone")));
                    if (a2.getInt(a2.getColumnIndex("msg_chat_switch")) == 0) {
                        ai.c().n(false);
                    } else {
                        ai.c().n(true);
                    }
                    if (a2.getInt(a2.getColumnIndex("nodisturb_switch")) == 0) {
                        ai.c().g(false);
                    } else {
                        ai.c().g(true);
                    }
                    String string = a2.getString(a2.getColumnIndex("nodisturb_start_time"));
                    if (TextUtils.isEmpty(string)) {
                        ai.c().g(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    } else {
                        ai.c().g(string);
                    }
                    String string2 = a2.getString(a2.getColumnIndex("nodisturb_end_time"));
                    if (TextUtils.isEmpty(string2)) {
                        ai.c().h(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    } else {
                        ai.c().h(string2);
                    }
                    if (a2.getInt(a2.getColumnIndex("remind_light")) == 0) {
                        ai.c().i(false);
                    } else {
                        ai.c().i(true);
                    }
                } else {
                    ai.c().b(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
                    ai.c().m(true);
                    ai.c().l(true);
                    ai.c().j(true);
                    ai.c().f(true);
                    ai.c().h(false);
                    ai.c().i(true);
                    ai.c().n(true);
                    ai.c().g(false);
                    ai.c().g(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    ai.c().h(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                }
                com.baidu.adp.lib.e.a.a(a2);
            } catch (Exception e) {
                b2.a(e, "getSettingData");
                com.baidu.adp.lib.e.a.a((Cursor) null);
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.e.a.a((Cursor) null);
            throw th;
        }
    }

    public static void g(String str) {
        if (str != null) {
            com.baidu.adp.base.a.c b2 = com.baidu.tbadk.j.a().b();
            b2.a("delete from cash_data where account=?", (Object[]) new String[]{str});
            b2.a("delete from mark_data where account=?", (Object[]) new String[]{str});
            b2.a("delete from draft_box where account=?", new Object[]{str});
            b2.a("delete from account_data where id=?", new Object[]{str});
            b2.a("delete from setting where account=?", new Object[]{str});
        }
    }

    public static boolean a(String str, int i) {
        com.baidu.adp.base.a.c b2 = com.baidu.tbadk.j.a().b();
        b2.a("delete from cash_data where type=?", (Object[]) new String[]{String.valueOf(i)});
        return b2.a("Insert into cash_data(type ,account ,data ) values(?,?,?)", (Object[]) new String[]{String.valueOf(i), "", str});
    }

    public static String b(int i) {
        Cursor cursor;
        Throwable th;
        com.baidu.adp.base.a.c b2 = com.baidu.tbadk.j.a().b();
        try {
            cursor = b2.a("select * from cash_data where type=? ", new String[]{String.valueOf(i)});
            try {
                try {
                    r0 = cursor.moveToFirst() ? cursor.getString(2) : null;
                    com.baidu.adp.lib.e.a.a(cursor);
                } catch (Exception e) {
                    e = e;
                    b2.a(e, "getNoAccountData");
                    com.baidu.adp.lib.e.a.a(cursor);
                    return r0;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.e.a.a(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.e.a.a(cursor);
            throw th;
        }
        return r0;
    }
}
