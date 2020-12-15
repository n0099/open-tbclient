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
/* loaded from: classes.dex */
public class a {
    private static Boolean noR = true;
    private static Boolean noS = true;

    public static void TU(String str) {
        bQ(13, str);
    }

    public static void dQf() {
        Lg(2);
    }

    private static void Lg(int i) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().execSQLNoException("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkCoreApplication.getCurrentAccount()});
        }
    }

    private static void bQ(int i, String str) {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().execSQLNoException("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
    }

    public static ArrayList<String> dQg() {
        return Lh(0);
    }

    public static ArrayList<String> dQh() {
        return Lh(1);
    }

    private static ArrayList<String> Lh(int i) {
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

    public static void TV(String str) {
        bR(0, str);
    }

    public static void TW(String str) {
        bR(1, str);
    }

    private static void bR(int i, String str) {
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

    public static void TX(String str) {
        bS(0, str);
    }

    private static void bS(int i, String str) {
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

    public static void dQi() {
        Li(0);
    }

    public static void dQj() {
        Li(1);
    }

    public static void Li(int i) {
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

    public static ArrayList<MarkData> dQk() {
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
            t(false);
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

    public static void t(Boolean bool) {
        noR = bool;
    }

    public static void bzm() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.execSQLNoException("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
            Object[] objArr = new Object[13];
            objArr[0] = TbadkCoreApplication.getCurrentAccount();
            objArr[1] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzo());
            objArr[2] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzr() ? 1 : 0);
            objArr[3] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzs() ? 1 : 0);
            objArr[4] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzq() ? 1 : 0);
            objArr[5] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzE());
            objArr[6] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzt() ? 1 : 0);
            objArr[7] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzw() ? 1 : 0);
            objArr[8] = com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzy();
            objArr[9] = com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzz();
            objArr[10] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzv() ? 1 : 0);
            objArr[11] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzp() ? 1 : 0);
            objArr[12] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzC() ? 1 : 0);
            mainDBDatabaseManager.execSQLNoException("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch,zan_me_switch) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", objArr);
        }
    }

    public static void dQl() {
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0 && TbadkCoreApplication.getCurrentAccountName() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                try {
                    Cursor rawQuery = mainDBDatabaseManager.rawQuery("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                    if (rawQuery != null && rawQuery.moveToFirst()) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().rJ(rawQuery.getInt(rawQuery.getColumnIndex("frequency")));
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().ka(rawQuery.getInt(rawQuery.getColumnIndex("fans_switch")) == 1);
                        if (rawQuery.getInt(rawQuery.getColumnIndex("reply_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jY(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jY(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("at_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jZ(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jZ(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("zan_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jR(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jR(true);
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().rK(rawQuery.getInt(rawQuery.getColumnIndex("remind_tone")));
                        if (rawQuery.getInt(rawQuery.getColumnIndex("msg_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jP(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jP(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("nodisturb_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jT(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jT(true);
                        }
                        String string = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_start_time"));
                        if (TextUtils.isEmpty(string)) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().CZ(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().CZ(string);
                        }
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_end_time"));
                        if (TextUtils.isEmpty(string2)) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().Da(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().Da(string2);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("remind_light")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jV(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jV(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("stranger_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jS(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jS(true);
                        }
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().rJ(300);
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().ka(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jY(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jZ(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jR(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jW(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jU(false);
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jV(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jS(false);
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jP(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().jT(false);
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().CZ(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        com.baidu.tbadk.coreExtra.messageCenter.d.bzl().Da(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
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
