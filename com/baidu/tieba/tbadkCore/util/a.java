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
    private static Boolean gLy = true;
    private static Boolean gLz = true;

    public static void tT(String str) {
        am(13, str);
    }

    public static void bxP() {
        tG(2);
    }

    private static void tG(int i) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().f("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkCoreApplication.getCurrentAccount()});
        }
    }

    private static void am(int i, String str) {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().f("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
    }

    public static ArrayList<String> bxQ() {
        return tH(0);
    }

    public static ArrayList<String> bxR() {
        return tH(1);
    }

    private static ArrayList<String> tH(int i) {
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

    public static void tU(String str) {
        an(0, str);
    }

    public static void tV(String str) {
        an(1, str);
    }

    private static void an(int i, String str) {
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

    public static void tW(String str) {
        ao(0, str);
    }

    private static void ao(int i, String str) {
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

    public static void bxS() {
        tI(0);
    }

    public static void bxT() {
        tI(1);
    }

    public static void tI(int i) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        switch (i) {
            case 0:
                mainDBDatabaseManager.O("delete from search_data");
                return;
            case 1:
                mainDBDatabaseManager.O("delete from search_post_data");
                return;
            default:
                return;
        }
    }

    public static ArrayList<MarkData> bxU() {
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
            g(false);
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

    public static void g(Boolean bool) {
        gLy = bool;
    }

    public static void DF() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.f("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
            Object[] objArr = new Object[13];
            objArr[0] = TbadkCoreApplication.getCurrentAccount();
            objArr[1] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DH());
            objArr[2] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DK() ? 1 : 0);
            objArr[3] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DL() ? 1 : 0);
            objArr[4] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DJ() ? 1 : 0);
            objArr[5] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DW());
            objArr[6] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DM() ? 1 : 0);
            objArr[7] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DP() ? 1 : 0);
            objArr[8] = com.baidu.tbadk.coreExtra.messageCenter.c.DE().DR();
            objArr[9] = com.baidu.tbadk.coreExtra.messageCenter.c.DE().DS();
            objArr[10] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DO() ? 1 : 0);
            objArr[11] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DI() ? 1 : 0);
            objArr[12] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.DE().DU() ? 1 : 0);
            mainDBDatabaseManager.f("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch,zan_me_switch) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", objArr);
        }
    }

    public static void bxV() {
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0 && TbadkCoreApplication.getCurrentAccountName() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                try {
                    Cursor rawQuery = mainDBDatabaseManager.rawQuery("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                    if (rawQuery != null && rawQuery.moveToFirst()) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().dX(rawQuery.getInt(rawQuery.getColumnIndex("frequency")));
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().bm(rawQuery.getInt(rawQuery.getColumnIndex("fans_switch")) == 1);
                        if (rawQuery.getInt(rawQuery.getColumnIndex("reply_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bk(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bk(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("at_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bl(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bl(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("zan_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bd(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bd(true);
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().dY(rawQuery.getInt(rawQuery.getColumnIndex("remind_tone")));
                        if (rawQuery.getInt(rawQuery.getColumnIndex("msg_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bb(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bb(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("nodisturb_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bf(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bf(true);
                        }
                        String string = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_start_time"));
                        if (TextUtils.isEmpty(string)) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().fF(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().fF(string);
                        }
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_end_time"));
                        if (TextUtils.isEmpty(string2)) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().fG(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().fG(string2);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("remind_light")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bh(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().bh(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("stranger_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().be(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.DE().be(true);
                        }
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().dX(300);
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().bm(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().bk(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().bl(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().bd(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().bi(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().bg(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().bh(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().be(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().bb(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().bf(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().fF(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        com.baidu.tbadk.coreExtra.messageCenter.c.DE().fG(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
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
