package com.baidu.tieba.tbadkCore.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m {
    private static Boolean dJi = true;
    private static Boolean dJj = true;

    public static void mx(String str) {
        O(13, str);
    }

    public static void aGj() {
        nf(2);
    }

    private static void nf(int i) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().a("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkCoreApplication.getCurrentAccount()});
        }
    }

    private static void O(int i, String str) {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().a("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
    }

    public static ArrayList<String> aGk() {
        return ng(0);
    }

    public static ArrayList<String> aGl() {
        return ng(1);
    }

    private static ArrayList<String> ng(int i) {
        Cursor cursor;
        Throwable th;
        Exception e;
        Cursor cursor2 = null;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            switch (i) {
                case 0:
                    cursor = mainDBDatabaseManager.rawQuery("select * from search_data order by time desc limit 5", null);
                    break;
                case 1:
                    cursor2 = mainDBDatabaseManager.rawQuery("select * from search_post_data order by time desc limit 5", null);
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
                        mainDBDatabaseManager.d(e, "getAllSearchData");
                        com.baidu.adp.lib.h.a.b(cursor);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.h.a.b(cursor);
                    throw th;
                }
            }
            com.baidu.adp.lib.h.a.b(cursor);
        } catch (Exception e3) {
            cursor = null;
            e = e3;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            com.baidu.adp.lib.h.a.b(cursor);
            throw th;
        }
        return arrayList;
    }

    public static void my(String str) {
        P(0, str);
    }

    public static void mz(String str) {
        P(1, str);
    }

    private static void P(int i, String str) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str != null) {
            switch (i) {
                case 0:
                    mainDBDatabaseManager.a("delete from search_data where key=?", new String[]{str});
                    mainDBDatabaseManager.a("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
                    return;
                case 1:
                    mainDBDatabaseManager.a("delete from search_post_data where key=?", new String[]{str});
                    mainDBDatabaseManager.a("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
                    return;
                default:
                    return;
            }
        }
    }

    public static void aGm() {
        nh(0);
    }

    public static void aGn() {
        nh(1);
    }

    public static void nh(int i) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        switch (i) {
            case 0:
                mainDBDatabaseManager.E("delete from search_data");
                return;
            case 1:
                mainDBDatabaseManager.E("delete from search_post_data");
                return;
            default:
                return;
        }
    }

    public static ArrayList<MarkData> aGo() {
        Throwable th;
        Cursor cursor;
        Exception e;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return null;
        }
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
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
                        mainDBDatabaseManager.d(e, "getAllMarkData");
                        com.baidu.adp.lib.h.a.b(cursor);
                        return arrayList;
                    }
                }
                h(false);
                com.baidu.adp.lib.h.a.b(cursor);
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.h.a.b((Cursor) null);
                throw th;
            }
        } catch (Exception e3) {
            cursor = null;
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.adp.lib.h.a.b((Cursor) null);
            throw th;
        }
        return arrayList;
    }

    public static void h(Boolean bool) {
        dJi = bool;
    }

    public static void xT() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.a("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
            Object[] objArr = new Object[12];
            objArr[0] = TbadkCoreApplication.getCurrentAccount();
            objArr[1] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xS().xV());
            objArr[2] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xS().xY() ? 1 : 0);
            objArr[3] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xS().xZ() ? 1 : 0);
            objArr[4] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xS().xX() ? 1 : 0);
            objArr[5] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xS().yl());
            objArr[6] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xS().ya() ? 1 : 0);
            objArr[7] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xS().yd() ? 1 : 0);
            objArr[8] = com.baidu.tbadk.coreExtra.messageCenter.c.xS().yf();
            objArr[9] = com.baidu.tbadk.coreExtra.messageCenter.c.xS().yg();
            objArr[10] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xS().yc() ? 1 : 0);
            objArr[11] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xS().xW() ? 1 : 0);
            mainDBDatabaseManager.a("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch) values(?,?,?,?,?,?,?,?,?,?,?,?)", objArr);
        }
    }

    public static void aGp() {
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0 && TbadkCoreApplication.getCurrentAccountName() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                try {
                    Cursor rawQuery = mainDBDatabaseManager.rawQuery("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                    if (rawQuery != null && rawQuery.moveToFirst()) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().dl(rawQuery.getInt(rawQuery.getColumnIndex("frequency")));
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().aN(rawQuery.getInt(rawQuery.getColumnIndex("fans_switch")) == 1);
                        if (rawQuery.getInt(rawQuery.getColumnIndex("reply_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aL(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aL(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("at_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aM(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aM(true);
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().dm(rawQuery.getInt(rawQuery.getColumnIndex("remind_tone")));
                        if (rawQuery.getInt(rawQuery.getColumnIndex("msg_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aB(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aB(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("nodisturb_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aF(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aF(true);
                        }
                        String string = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_start_time"));
                        if (TextUtils.isEmpty(string)) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().ek(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().ek(string);
                        }
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_end_time"));
                        if (TextUtils.isEmpty(string2)) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().el(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().el(string2);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("remind_light")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aH(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aH(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("stranger_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aE(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xS().aE(true);
                        }
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().dl(300);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().aN(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().aL(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().aM(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().aI(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().aG(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().aH(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().aE(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().aB(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().aF(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().ek(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xS().el(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    }
                    com.baidu.adp.lib.h.a.b(rawQuery);
                } catch (Exception e) {
                    mainDBDatabaseManager.d(e, "getSettingData");
                    com.baidu.adp.lib.h.a.b((Cursor) null);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SETTING_READ_FINISH));
            } catch (Throwable th) {
                com.baidu.adp.lib.h.a.b((Cursor) null);
                throw th;
            }
        }
    }

    public static boolean cashNoAccountData(String str, int i) {
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.a("delete from cash_data where type=?", new String[]{String.valueOf(i)});
        return mainDBDatabaseManager.a("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i), "", str});
    }
}
