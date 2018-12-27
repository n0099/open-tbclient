package com.baidu.tieba.tbadkCore.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private static Boolean hrb = true;
    private static Boolean hrc = true;

    public static void vN(String str) {
        ak(13, str);
    }

    public static void bEX() {
        vP(2);
    }

    private static void vP(int i) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().f("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkCoreApplication.getCurrentAccount()});
        }
    }

    private static void ak(int i, String str) {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().f("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
    }

    public static ArrayList<String> bEY() {
        return vQ(0);
    }

    public static ArrayList<String> bEZ() {
        return vQ(1);
    }

    private static ArrayList<String> vQ(int i) {
        Cursor cursor = null;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            switch (i) {
                case 0:
                    cursor = mainDBDatabaseManager.rawQuery("select * from search_data order by time desc limit 20", null);
                    break;
                case 1:
                    cursor = mainDBDatabaseManager.rawQuery("select * from search_post_data order by time desc limit 5", null);
                    break;
            }
            while (cursor.moveToNext()) {
                String string = cursor.getString(0);
                if (string != null && string.length() > 0) {
                    arrayList.add(string);
                }
            }
        } catch (Exception e) {
            mainDBDatabaseManager.a(e, "getAllSearchData");
        } finally {
            com.baidu.adp.lib.g.a.e(cursor);
        }
        return arrayList;
    }

    public static void vO(String str) {
        al(0, str);
    }

    public static void vP(String str) {
        al(1, str);
    }

    private static void al(int i, String str) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str != null) {
            switch (i) {
                case 0:
                    mainDBDatabaseManager.f("delete from search_data where key=?", new String[]{str});
                    mainDBDatabaseManager.f("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
                    return;
                case 1:
                    mainDBDatabaseManager.f("delete from search_post_data where key=?", new String[]{str});
                    mainDBDatabaseManager.f("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
                    return;
                default:
                    return;
            }
        }
    }

    public static void vQ(String str) {
        am(0, str);
    }

    private static void am(int i, String str) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str != null) {
            switch (i) {
                case 0:
                    mainDBDatabaseManager.f("delete from search_data where key=?", new String[]{str});
                    return;
                case 1:
                    mainDBDatabaseManager.f("delete from search_post_data where key=?", new String[]{str});
                    return;
                default:
                    return;
            }
        }
    }

    public static void bFa() {
        vR(0);
    }

    public static void bFb() {
        vR(1);
    }

    public static void vR(int i) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        switch (i) {
            case 0:
                mainDBDatabaseManager.af("delete from search_data");
                return;
            case 1:
                mainDBDatabaseManager.af("delete from search_post_data");
                return;
            default:
                return;
        }
    }

    public static ArrayList<MarkData> bFc() {
        Cursor cursor;
        Throwable th;
        Exception e;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            cursor = mainDBDatabaseManager.rawQuery("select * from mark_data where account=? order by time desc", new String[]{TbadkCoreApplication.getCurrentAccount()});
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
                        mainDBDatabaseManager.a(e, "getAllMarkData");
                        com.baidu.adp.lib.g.a.e(cursor);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.g.a.e(cursor);
                    throw th;
                }
            }
            h(false);
            com.baidu.adp.lib.g.a.e(cursor);
        } catch (Exception e3) {
            cursor = null;
            e = e3;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.g.a.e(cursor);
            throw th;
        }
        return arrayList;
    }

    public static void h(Boolean bool) {
        hrb = bool;
    }

    public static void Iy() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.f("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
            Object[] objArr = new Object[13];
            objArr[0] = TbadkCoreApplication.getCurrentAccount();
            objArr[1] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IA());
            objArr[2] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().ID() ? 1 : 0);
            objArr[3] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IE() ? 1 : 0);
            objArr[4] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IC() ? 1 : 0);
            objArr[5] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IQ());
            objArr[6] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IF() ? 1 : 0);
            objArr[7] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().II() ? 1 : 0);
            objArr[8] = com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IK();
            objArr[9] = com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IL();
            objArr[10] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IH() ? 1 : 0);
            objArr[11] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IB() ? 1 : 0);
            objArr[12] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IO() ? 1 : 0);
            mainDBDatabaseManager.f("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch,zan_me_switch) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", objArr);
        }
    }

    public static void bFd() {
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0 && TbadkCoreApplication.getCurrentAccountName() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                try {
                    Cursor rawQuery = mainDBDatabaseManager.rawQuery("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                    if (rawQuery != null && rawQuery.moveToFirst()) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().eY(rawQuery.getInt(rawQuery.getColumnIndex("frequency")));
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().cb(rawQuery.getInt(rawQuery.getColumnIndex("fans_switch")) == 1);
                        if (rawQuery.getInt(rawQuery.getColumnIndex("reply_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bZ(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bZ(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("at_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().ca(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().ca(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("zan_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bS(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bS(true);
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().eZ(rawQuery.getInt(rawQuery.getColumnIndex("remind_tone")));
                        if (rawQuery.getInt(rawQuery.getColumnIndex("msg_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bQ(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bQ(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("nodisturb_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bU(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bU(true);
                        }
                        String string = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_start_time"));
                        if (TextUtils.isEmpty(string)) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().gM(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().gM(string);
                        }
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_end_time"));
                        if (TextUtils.isEmpty(string2)) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().gN(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().gN(string2);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("remind_light")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bW(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bW(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("stranger_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bT(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bT(true);
                        }
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().eY(300);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().cb(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bZ(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().ca(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bS(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bX(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bV(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bW(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bT(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bQ(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().bU(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().gM(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Ix().gN(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    }
                    com.baidu.adp.lib.g.a.e(rawQuery);
                } catch (Exception e) {
                    mainDBDatabaseManager.a(e, "getSettingData");
                    com.baidu.adp.lib.g.a.e(null);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001311));
            } catch (Throwable th) {
                com.baidu.adp.lib.g.a.e(null);
                throw th;
            }
        }
    }

    public static boolean cashNoAccountData(String str, int i) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.f("delete from cash_data where type=?", new String[]{String.valueOf(i)});
        return mainDBDatabaseManager.f("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i), "", str});
    }
}
