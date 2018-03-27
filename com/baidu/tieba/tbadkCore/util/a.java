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
    private static Boolean hdB = true;
    private static Boolean hdC = true;

    public static void sP(String str) {
        ag(13, str);
    }

    public static void bxM() {
        vT(2);
    }

    private static void vT(int i) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().f("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkCoreApplication.getCurrentAccount()});
        }
    }

    private static void ag(int i, String str) {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().f("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
    }

    public static ArrayList<String> bxN() {
        return vU(0);
    }

    public static ArrayList<String> bxO() {
        return vU(1);
    }

    private static ArrayList<String> vU(int i) {
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
            com.baidu.adp.lib.g.a.i(cursor);
        }
        return arrayList;
    }

    public static void sQ(String str) {
        ah(0, str);
    }

    public static void sR(String str) {
        ah(1, str);
    }

    private static void ah(int i, String str) {
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

    public static void sS(String str) {
        ai(0, str);
    }

    private static void ai(int i, String str) {
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

    public static void bxP() {
        vV(0);
    }

    public static void bxQ() {
        vV(1);
    }

    public static void vV(int i) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        switch (i) {
            case 0:
                mainDBDatabaseManager.F("delete from search_data");
                return;
            case 1:
                mainDBDatabaseManager.F("delete from search_post_data");
                return;
            default:
                return;
        }
    }

    public static ArrayList<MarkData> bxR() {
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
                        com.baidu.adp.lib.g.a.i(cursor);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.g.a.i(cursor);
                    throw th;
                }
            }
            g(false);
            com.baidu.adp.lib.g.a.i(cursor);
        } catch (Exception e3) {
            cursor = null;
            e = e3;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.g.a.i(cursor);
            throw th;
        }
        return arrayList;
    }

    public static void g(Boolean bool) {
        hdB = bool;
    }

    public static void Hr() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.f("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
            Object[] objArr = new Object[13];
            objArr[0] = TbadkCoreApplication.getCurrentAccount();
            objArr[1] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Ht());
            objArr[2] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hw() ? 1 : 0);
            objArr[3] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hx() ? 1 : 0);
            objArr[4] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hv() ? 1 : 0);
            objArr[5] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HI());
            objArr[6] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hy() ? 1 : 0);
            objArr[7] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HB() ? 1 : 0);
            objArr[8] = com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HD();
            objArr[9] = com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HE();
            objArr[10] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HA() ? 1 : 0);
            objArr[11] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hu() ? 1 : 0);
            objArr[12] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HG() ? 1 : 0);
            mainDBDatabaseManager.f("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch,zan_me_switch) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", objArr);
        }
    }

    public static void bxS() {
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0 && TbadkCoreApplication.getCurrentAccountName() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                try {
                    Cursor rawQuery = mainDBDatabaseManager.rawQuery("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                    if (rawQuery != null && rawQuery.moveToFirst()) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().gW(rawQuery.getInt(rawQuery.getColumnIndex("frequency")));
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bQ(rawQuery.getInt(rawQuery.getColumnIndex("fans_switch")) == 1);
                        if (rawQuery.getInt(rawQuery.getColumnIndex("reply_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bO(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bO(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("at_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bP(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bP(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("zan_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bH(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bH(true);
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().gX(rawQuery.getInt(rawQuery.getColumnIndex("remind_tone")));
                        if (rawQuery.getInt(rawQuery.getColumnIndex("msg_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bF(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bF(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("nodisturb_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bJ(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bJ(true);
                        }
                        String string = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_start_time"));
                        if (TextUtils.isEmpty(string)) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().fq(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().fq(string);
                        }
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_end_time"));
                        if (TextUtils.isEmpty(string2)) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().fr(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().fr(string2);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("remind_light")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bL(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bL(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("stranger_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bI(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bI(true);
                        }
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().gW(300);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bQ(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bO(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bP(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bH(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bM(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bK(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bL(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bI(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bF(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().bJ(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().fq(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        com.baidu.tbadk.coreExtra.messageCenter.c.Hq().fr(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    }
                    com.baidu.adp.lib.g.a.i(rawQuery);
                } catch (Exception e) {
                    mainDBDatabaseManager.a(e, "getSettingData");
                    com.baidu.adp.lib.g.a.i(null);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001311));
            } catch (Throwable th) {
                com.baidu.adp.lib.g.a.i(null);
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
