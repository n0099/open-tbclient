package com.baidu.tieba.tbadkCore.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    private static Boolean mhG = true;
    private static Boolean mhH = true;

    public static void QQ(String str) {
        bA(13, str);
    }

    public static void dxt() {
        HZ(2);
    }

    private static void HZ(int i) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().execSQLNoException("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkCoreApplication.getCurrentAccount()});
        }
    }

    private static void bA(int i, String str) {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().execSQLNoException("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
    }

    public static ArrayList<String> dxu() {
        return Ia(0);
    }

    public static ArrayList<String> dxv() {
        return Ia(1);
    }

    private static ArrayList<String> Ia(int i) {
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
            mainDBDatabaseManager.notifySQLException(e, "getAllSearchData");
        } finally {
            com.baidu.adp.lib.f.a.close(cursor);
        }
        return arrayList;
    }

    public static void QR(String str) {
        bB(0, str);
    }

    public static void QS(String str) {
        bB(1, str);
    }

    private static void bB(int i, String str) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str != null) {
            switch (i) {
                case 0:
                    mainDBDatabaseManager.execSQLNoException("delete from search_data where key=?", new String[]{str});
                    mainDBDatabaseManager.execSQLNoException("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
                    return;
                case 1:
                    mainDBDatabaseManager.execSQLNoException("delete from search_post_data where key=?", new String[]{str});
                    mainDBDatabaseManager.execSQLNoException("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
                    return;
                default:
                    return;
            }
        }
    }

    public static void QT(String str) {
        bC(0, str);
    }

    private static void bC(int i, String str) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str != null) {
            switch (i) {
                case 0:
                    mainDBDatabaseManager.execSQLNoException("delete from search_data where key=?", new String[]{str});
                    return;
                case 1:
                    mainDBDatabaseManager.execSQLNoException("delete from search_post_data where key=?", new String[]{str});
                    return;
                default:
                    return;
            }
        }
    }

    public static void dxw() {
        Ib(0);
    }

    public static void dxx() {
        Ib(1);
    }

    public static void Ib(int i) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        switch (i) {
            case 0:
                mainDBDatabaseManager.execSQLNoException("delete from search_data");
                return;
            case 1:
                mainDBDatabaseManager.execSQLNoException("delete from search_post_data");
                return;
            default:
                return;
        }
    }

    public static ArrayList<MarkData> dxy() {
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
                        mainDBDatabaseManager.notifySQLException(e, "getAllMarkData");
                        com.baidu.adp.lib.f.a.close(cursor);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.f.a.close(cursor);
                    throw th;
                }
            }
            r(false);
            com.baidu.adp.lib.f.a.close(cursor);
        } catch (Exception e3) {
            cursor = null;
            e = e3;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.f.a.close(cursor);
            throw th;
        }
        return arrayList;
    }

    public static void r(Boolean bool) {
        mhG = bool;
    }

    public static void boz() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.execSQLNoException("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
            Object[] objArr = new Object[13];
            objArr[0] = TbadkCoreApplication.getCurrentAccount();
            objArr[1] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boB());
            objArr[2] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boE() ? 1 : 0);
            objArr[3] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boF() ? 1 : 0);
            objArr[4] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boD() ? 1 : 0);
            objArr[5] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boR());
            objArr[6] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boG() ? 1 : 0);
            objArr[7] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boJ() ? 1 : 0);
            objArr[8] = com.baidu.tbadk.coreExtra.messageCenter.d.boy().boL();
            objArr[9] = com.baidu.tbadk.coreExtra.messageCenter.d.boy().boM();
            objArr[10] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boI() ? 1 : 0);
            objArr[11] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boC() ? 1 : 0);
            objArr[12] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.boy().boP() ? 1 : 0);
            mainDBDatabaseManager.execSQLNoException("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch,zan_me_switch) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", objArr);
        }
    }

    public static void dxz() {
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0 && TbadkCoreApplication.getCurrentAccountName() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                try {
                    Cursor rawQuery = mainDBDatabaseManager.rawQuery("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                    if (rawQuery != null && rawQuery.moveToFirst()) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().pE(rawQuery.getInt(rawQuery.getColumnIndex("frequency")));
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().iR(rawQuery.getInt(rawQuery.getColumnIndex("fans_switch")) == 1);
                        if (rawQuery.getInt(rawQuery.getColumnIndex("reply_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iP(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iP(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("at_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iQ(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iQ(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("zan_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iI(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iI(true);
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().pF(rawQuery.getInt(rawQuery.getColumnIndex("remind_tone")));
                        if (rawQuery.getInt(rawQuery.getColumnIndex("msg_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iG(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iG(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("nodisturb_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iK(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iK(true);
                        }
                        String string = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_start_time"));
                        if (TextUtils.isEmpty(string)) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().Bc(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().Bc(string);
                        }
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_end_time"));
                        if (TextUtils.isEmpty(string2)) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().Bd(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().Bd(string2);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("remind_light")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iM(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iM(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("stranger_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iJ(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.boy().iJ(true);
                        }
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().pE(300);
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().iR(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().iP(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().iQ(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().iI(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().iN(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().iL(false);
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().iM(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().iJ(false);
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().iG(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().iK(false);
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().Bc(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        com.baidu.tbadk.coreExtra.messageCenter.d.boy().Bd(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    }
                    com.baidu.adp.lib.f.a.close(rawQuery);
                } catch (Exception e) {
                    mainDBDatabaseManager.notifySQLException(e, "getSettingData");
                    com.baidu.adp.lib.f.a.close((Cursor) null);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SETTING_READ_FINISH));
            } catch (Throwable th) {
                com.baidu.adp.lib.f.a.close((Cursor) null);
                throw th;
            }
        }
    }

    public static boolean cashNoAccountData(String str, int i) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.execSQLNoException("delete from cash_data where type=?", new String[]{String.valueOf(i)});
        return mainDBDatabaseManager.execSQLNoException("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i), "", str});
    }
}
