package com.baidu.tieba.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tieba.aj;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class j {
    private static Boolean bPW = true;
    private static Boolean bPX = true;

    public static void hx(String str) {
        s(13, str);
    }

    public static void aey() {
        hw(2);
    }

    public static void hy(String str) {
        r(4, str);
    }

    public static void aez() {
        hw(4);
    }

    public static String aeA() {
        return hx(4);
    }

    private static void r(int i, String str) {
        if (TbadkApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.a("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkApplication.getCurrentAccount()});
            mainDBDatabaseManager.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{TbadkApplication.getCurrentAccount(), Integer.valueOf(i), str});
        }
    }

    private static void hw(int i) {
        if (TbadkApplication.getCurrentAccount() != null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().a("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkApplication.getCurrentAccount()});
        }
    }

    private static String hx(int i) {
        Cursor cursor;
        Throwable th;
        String str = null;
        if (TbadkApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                cursor = mainDBDatabaseManager.rawQuery("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), TbadkApplication.getCurrentAccount()});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                str = cursor.getString(2);
                            }
                        } catch (Exception e) {
                            e = e;
                            mainDBDatabaseManager.a(e, "getCachData");
                            com.baidu.adp.lib.g.a.a(cursor);
                            return str;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.g.a.a(cursor);
                        throw th;
                    }
                }
                com.baidu.adp.lib.g.a.a(cursor);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                com.baidu.adp.lib.g.a.a(cursor);
                throw th;
            }
        }
        return str;
    }

    private static void s(int i, String str) {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().a("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
    }

    public static ArrayList<String> aeB() {
        return hy(0);
    }

    public static ArrayList<String> aeC() {
        return hy(1);
    }

    private static ArrayList<String> hy(int i) {
        Cursor cursor;
        Throwable th;
        Exception e;
        Cursor cursor2 = null;
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            switch (i) {
                case 0:
                    cursor = mainDBDatabaseManager.rawQuery("select * from search_data order by time desc limit 10", null);
                    break;
                case 1:
                    cursor2 = mainDBDatabaseManager.rawQuery("select * from search_post_data order by time desc limit 10", null);
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
                        mainDBDatabaseManager.a(e, "getAllSearchData");
                        com.baidu.adp.lib.g.a.a(cursor);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.g.a.a(cursor);
                    throw th;
                }
            }
            com.baidu.adp.lib.g.a.a(cursor);
        } catch (Exception e3) {
            cursor = null;
            e = e3;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.g.a.a(cursor);
            throw th;
        }
        return arrayList;
    }

    public static void hz(String str) {
        t(0, str);
    }

    public static void hA(String str) {
        t(1, str);
    }

    private static void t(int i, String str) {
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str != null) {
            Date date = new Date();
            switch (i) {
                case 0:
                    mainDBDatabaseManager.a("delete from search_data where key=?", new String[]{str});
                    mainDBDatabaseManager.a("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkApplication.getCurrentAccount(), Long.valueOf(date.getTime())});
                    return;
                case 1:
                    mainDBDatabaseManager.a("delete from search_post_data where key=?", new String[]{str});
                    mainDBDatabaseManager.a("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkApplication.getCurrentAccount(), Long.valueOf(date.getTime())});
                    return;
                default:
                    return;
            }
        }
    }

    public static void aeD() {
        hz(0);
    }

    public static void aeE() {
        hz(1);
    }

    public static void hz(int i) {
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        switch (i) {
            case 0:
                mainDBDatabaseManager.g("delete from search_data");
                return;
            case 1:
                mainDBDatabaseManager.g("delete from search_post_data");
                return;
            default:
                return;
        }
    }

    public static ArrayList<MarkData> aeF() {
        Throwable th;
        Cursor cursor;
        Exception e;
        if (TbadkApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            try {
                cursor = mainDBDatabaseManager.rawQuery("select * from mark_data where account=? order by time desc", new String[]{TbadkApplication.getCurrentAccount()});
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
                        mainDBDatabaseManager.a(e, "getAllMarkData");
                        com.baidu.adp.lib.g.a.a(cursor);
                        return arrayList;
                    }
                }
                h(false);
                com.baidu.adp.lib.g.a.a(cursor);
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.a((Cursor) null);
                throw th;
            }
        } catch (Exception e3) {
            cursor = null;
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.adp.lib.g.a.a((Cursor) null);
            throw th;
        }
        return arrayList;
    }

    public static void h(Boolean bool) {
        bPW = bool;
    }

    public static void aeG() {
        if (TbadkApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.a("delete from setting where account=?", new Object[]{TbadkApplication.getCurrentAccount()});
            Object[] objArr = new Object[11];
            objArr[0] = TbadkApplication.getCurrentAccount();
            objArr[1] = Integer.valueOf(TbadkApplication.m251getInst().getMsgFrequency());
            objArr[2] = Integer.valueOf(TbadkApplication.m251getInst().isMsgNewFansOn() ? 1 : 0);
            objArr[3] = Integer.valueOf(TbadkApplication.m251getInst().isMsgReplymeOn() ? 1 : 0);
            objArr[4] = Integer.valueOf(TbadkApplication.m251getInst().isMsgAtmeOn() ? 1 : 0);
            objArr[5] = Integer.valueOf(aj.wk().wy());
            objArr[6] = Integer.valueOf(TbadkApplication.m251getInst().isMsgChatOn() ? 1 : 0);
            objArr[7] = Integer.valueOf(TbadkApplication.m251getInst().isNoDisturbOn() ? 1 : 0);
            objArr[8] = TbadkApplication.m251getInst().getNoDisturbStartTime();
            objArr[9] = TbadkApplication.m251getInst().getNoDisturbEndTime();
            objArr[10] = Integer.valueOf(TbadkApplication.m251getInst().isMsgLightOn() ? 1 : 0);
            mainDBDatabaseManager.a("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light) values(?,?,?,?,?,?,?,?,?,?,?)", objArr);
        }
    }

    public static void aeH() {
        if (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccount().length() <= 0 || TbadkApplication.getCurrentAccountName() == null) {
            aj.wk().dA(0);
            return;
        }
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            try {
                Cursor rawQuery = mainDBDatabaseManager.rawQuery("select * from setting where account=?", new String[]{TbadkApplication.getCurrentAccount()});
                if (rawQuery != null && rawQuery.moveToFirst()) {
                    aj.wk().dA(rawQuery.getInt(rawQuery.getColumnIndex("frequency")));
                    aj.wk().aY(rawQuery.getInt(rawQuery.getColumnIndex("fans_switch")) == 1);
                    if (rawQuery.getInt(rawQuery.getColumnIndex("reply_me_switch")) == 0) {
                        aj.wk().aX(false);
                    } else {
                        aj.wk().aX(true);
                    }
                    if (rawQuery.getInt(rawQuery.getColumnIndex("at_me_switch")) == 0) {
                        aj.wk().aW(false);
                    } else {
                        aj.wk().aW(true);
                    }
                    aj.wk().dz(rawQuery.getInt(rawQuery.getColumnIndex("remind_tone")));
                    if (rawQuery.getInt(rawQuery.getColumnIndex("msg_chat_switch")) == 0) {
                        aj.wk().aZ(false);
                    } else {
                        aj.wk().aZ(true);
                    }
                    if (rawQuery.getInt(rawQuery.getColumnIndex("nodisturb_switch")) == 0) {
                        aj.wk().aT(false);
                    } else {
                        aj.wk().aT(true);
                    }
                    String string = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_start_time"));
                    if (TextUtils.isEmpty(string)) {
                        aj.wk().dZ(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    } else {
                        aj.wk().dZ(string);
                    }
                    String string2 = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_end_time"));
                    if (TextUtils.isEmpty(string2)) {
                        aj.wk().ea(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    } else {
                        aj.wk().ea(string2);
                    }
                    if (rawQuery.getInt(rawQuery.getColumnIndex("remind_light")) == 0) {
                        aj.wk().aV(false);
                    } else {
                        aj.wk().aV(true);
                    }
                } else {
                    aj.wk().dA(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
                    aj.wk().aY(true);
                    aj.wk().aX(true);
                    aj.wk().aW(true);
                    aj.wk().aS(true);
                    aj.wk().aU(false);
                    aj.wk().aV(true);
                    aj.wk().aZ(true);
                    aj.wk().aT(false);
                    aj.wk().dZ(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    aj.wk().ea(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                }
                com.baidu.adp.lib.g.a.a(rawQuery);
            } catch (Exception e) {
                mainDBDatabaseManager.a(e, "getSettingData");
                com.baidu.adp.lib.g.a.a((Cursor) null);
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.g.a.a((Cursor) null);
            throw th;
        }
    }

    public static void hB(String str) {
        if (str != null) {
            com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.a("delete from cash_data where account=?", new String[]{str});
            mainDBDatabaseManager.a("delete from mark_data where account=?", new String[]{str});
            mainDBDatabaseManager.a("delete from draft_box where account=?", new Object[]{str});
            mainDBDatabaseManager.a("delete from account_data where id=?", new Object[]{str});
            mainDBDatabaseManager.a("delete from setting where account=?", new Object[]{str});
        }
    }

    public static boolean M(String str, int i) {
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.a("delete from cash_data where type=?", new String[]{String.valueOf(i)});
        return mainDBDatabaseManager.a("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i), "", str});
    }

    public static String hA(int i) {
        Cursor cursor;
        Throwable th;
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from cash_data where type=? ", new String[]{String.valueOf(i)});
            try {
                try {
                    r0 = cursor.moveToFirst() ? cursor.getString(2) : null;
                    com.baidu.adp.lib.g.a.a(cursor);
                } catch (Exception e) {
                    e = e;
                    mainDBDatabaseManager.a(e, "getNoAccountData");
                    com.baidu.adp.lib.g.a.a(cursor);
                    return r0;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.a(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.g.a.a(cursor);
            throw th;
        }
        return r0;
    }
}
