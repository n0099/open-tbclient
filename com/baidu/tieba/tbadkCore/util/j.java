package com.baidu.tieba.tbadkCore.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class j {
    private static Boolean bYN = true;
    private static Boolean bYO = true;

    public static void ik(String str) {
        D(13, str);
    }

    public static void delPersonData() {
        delCachData(2);
    }

    private static void delCachData(int i) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().a("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkCoreApplication.getCurrentAccount()});
        }
    }

    private static void D(int i, String str) {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().a("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
    }

    public static ArrayList<String> ahL() {
        return hW(0);
    }

    public static ArrayList<String> ahM() {
        return hW(1);
    }

    private static ArrayList<String> hW(int i) {
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
                        com.baidu.adp.lib.g.a.b(cursor);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.g.a.b(cursor);
                    throw th;
                }
            }
            com.baidu.adp.lib.g.a.b(cursor);
        } catch (Exception e3) {
            cursor = null;
            e = e3;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.g.a.b(cursor);
            throw th;
        }
        return arrayList;
    }

    public static void il(String str) {
        E(0, str);
    }

    public static void im(String str) {
        E(1, str);
    }

    private static void E(int i, String str) {
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str != null) {
            Date date = new Date();
            switch (i) {
                case 0:
                    mainDBDatabaseManager.a("delete from search_data where key=?", new String[]{str});
                    mainDBDatabaseManager.a("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime())});
                    return;
                case 1:
                    mainDBDatabaseManager.a("delete from search_post_data where key=?", new String[]{str});
                    mainDBDatabaseManager.a("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime())});
                    return;
                default:
                    return;
            }
        }
    }

    public static void ahN() {
        hX(0);
    }

    public static void ahO() {
        hX(1);
    }

    public static void hX(int i) {
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        switch (i) {
            case 0:
                mainDBDatabaseManager.t("delete from search_data");
                return;
            case 1:
                mainDBDatabaseManager.t("delete from search_post_data");
                return;
            default:
                return;
        }
    }

    public static ArrayList<MarkData> ahP() {
        Throwable th;
        Cursor cursor;
        Exception e;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            try {
                cursor = mainDBDatabaseManager.rawQuery("select * from mark_data where account=? order by time desc", new String[]{TbadkCoreApplication.getCurrentAccount()});
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
                        com.baidu.adp.lib.g.a.b(cursor);
                        return arrayList;
                    }
                }
                h(false);
                com.baidu.adp.lib.g.a.b(cursor);
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.b((Cursor) null);
                throw th;
            }
        } catch (Exception e3) {
            cursor = null;
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.adp.lib.g.a.b((Cursor) null);
            throw th;
        }
        return arrayList;
    }

    public static void h(Boolean bool) {
        bYN = bool;
    }

    public static void ahQ() {
        if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0 || TbadkCoreApplication.getCurrentAccountName() == null) {
            TbadkCoreApplication.m255getInst().setMsgFrequency(0);
            return;
        }
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            try {
                Cursor rawQuery = mainDBDatabaseManager.rawQuery("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                if (rawQuery != null && rawQuery.moveToFirst()) {
                    TbadkCoreApplication.m255getInst().setMsgFrequency(rawQuery.getInt(rawQuery.getColumnIndex("frequency")));
                    TbadkCoreApplication.m255getInst().setMsgNewFansOn(rawQuery.getInt(rawQuery.getColumnIndex("fans_switch")) == 1);
                    if (rawQuery.getInt(rawQuery.getColumnIndex("reply_me_switch")) == 0) {
                        TbadkCoreApplication.m255getInst().setMsgReplymeOn(false);
                    } else {
                        TbadkCoreApplication.m255getInst().setMsgReplymeOn(true);
                    }
                    if (rawQuery.getInt(rawQuery.getColumnIndex("at_me_switch")) == 0) {
                        TbadkCoreApplication.m255getInst().setMsgAtmeOn(false);
                    } else {
                        TbadkCoreApplication.m255getInst().setMsgAtmeOn(true);
                    }
                    TbadkCoreApplication.m255getInst().decodeMsgToneDbState(rawQuery.getInt(rawQuery.getColumnIndex("remind_tone")));
                    if (rawQuery.getInt(rawQuery.getColumnIndex("msg_chat_switch")) == 0) {
                        TbadkCoreApplication.m255getInst().setMsgChatOn(false);
                    } else {
                        TbadkCoreApplication.m255getInst().setMsgChatOn(true);
                    }
                    if (rawQuery.getInt(rawQuery.getColumnIndex("nodisturb_switch")) == 0) {
                        TbadkCoreApplication.m255getInst().setNoDisturbOn(false);
                    } else {
                        TbadkCoreApplication.m255getInst().setNoDisturbOn(true);
                    }
                    String string = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_start_time"));
                    if (TextUtils.isEmpty(string)) {
                        TbadkCoreApplication.m255getInst().setNoDisturbStartTime(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    } else {
                        TbadkCoreApplication.m255getInst().setNoDisturbStartTime(string);
                    }
                    String string2 = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_end_time"));
                    if (TextUtils.isEmpty(string2)) {
                        TbadkCoreApplication.m255getInst().setNoDisturbEndTime(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    } else {
                        TbadkCoreApplication.m255getInst().setNoDisturbEndTime(string2);
                    }
                    if (rawQuery.getInt(rawQuery.getColumnIndex("remind_light")) == 0) {
                        TbadkCoreApplication.m255getInst().setMsgLight(false);
                    } else {
                        TbadkCoreApplication.m255getInst().setMsgLight(true);
                    }
                    if (rawQuery.getInt(rawQuery.getColumnIndex("stranger_chat_switch")) == 0) {
                        TbadkCoreApplication.m255getInst().setStrangerChatOn(false);
                    } else {
                        TbadkCoreApplication.m255getInst().setStrangerChatOn(true);
                    }
                } else {
                    TbadkCoreApplication.m255getInst().setMsgFrequency(300);
                    TbadkCoreApplication.m255getInst().setMsgNewFansOn(true);
                    TbadkCoreApplication.m255getInst().setMsgReplymeOn(true);
                    TbadkCoreApplication.m255getInst().setMsgAtmeOn(true);
                    TbadkCoreApplication.m255getInst().setMsgTone(true);
                    TbadkCoreApplication.m255getInst().setMsgVibrate(false);
                    TbadkCoreApplication.m255getInst().setMsgLight(true);
                    TbadkCoreApplication.m255getInst().setStrangerChatOn(true);
                    TbadkCoreApplication.m255getInst().setMsgChatOn(true);
                    TbadkCoreApplication.m255getInst().setNoDisturbOn(false);
                    TbadkCoreApplication.m255getInst().setNoDisturbStartTime(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    TbadkCoreApplication.m255getInst().setNoDisturbEndTime(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                }
                com.baidu.adp.lib.g.a.b(rawQuery);
            } catch (Exception e) {
                mainDBDatabaseManager.a(e, "getSettingData");
                com.baidu.adp.lib.g.a.b((Cursor) null);
            }
        } catch (Throwable th) {
            com.baidu.adp.lib.g.a.b((Cursor) null);
            throw th;
        }
    }

    public static boolean cashNoAccountData(String str, int i) {
        com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.a("delete from cash_data where type=?", new String[]{String.valueOf(i)});
        return mainDBDatabaseManager.a("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i), "", str});
    }
}
