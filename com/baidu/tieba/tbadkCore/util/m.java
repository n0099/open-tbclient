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
    private static Boolean dbj = true;
    private static Boolean dbk = true;

    public static void lF(String str) {
        L(13, str);
    }

    public static void axx() {
        ld(2);
    }

    private static void ld(int i) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().a("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkCoreApplication.getCurrentAccount()});
        }
    }

    private static void L(int i, String str) {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().a("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
    }

    public static ArrayList<String> axy() {
        return le(0);
    }

    public static ArrayList<String> axz() {
        return le(1);
    }

    private static ArrayList<String> le(int i) {
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

    public static void lG(String str) {
        M(0, str);
    }

    public static void lH(String str) {
        M(1, str);
    }

    private static void M(int i, String str) {
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

    public static void axA() {
        lf(0);
    }

    public static void axB() {
        lf(1);
    }

    public static void lf(int i) {
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

    public static ArrayList<MarkData> axC() {
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
        dbj = bool;
    }

    public static void xf() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.a("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
            Object[] objArr = new Object[12];
            objArr[0] = TbadkCoreApplication.getCurrentAccount();
            objArr[1] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xe().xh());
            objArr[2] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xe().xk() ? 1 : 0);
            objArr[3] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xe().xl() ? 1 : 0);
            objArr[4] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xe().xj() ? 1 : 0);
            objArr[5] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xe().xx());
            objArr[6] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xe().xm() ? 1 : 0);
            objArr[7] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xe().xp() ? 1 : 0);
            objArr[8] = com.baidu.tbadk.coreExtra.messageCenter.c.xe().xr();
            objArr[9] = com.baidu.tbadk.coreExtra.messageCenter.c.xe().xs();
            objArr[10] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xe().xo() ? 1 : 0);
            objArr[11] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.c.xe().xi() ? 1 : 0);
            mainDBDatabaseManager.a("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch) values(?,?,?,?,?,?,?,?,?,?,?,?)", objArr);
        }
    }

    public static void axD() {
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0 && TbadkCoreApplication.getCurrentAccountName() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                try {
                    Cursor rawQuery = mainDBDatabaseManager.rawQuery("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                    if (rawQuery != null && rawQuery.moveToFirst()) {
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().dc(rawQuery.getInt(rawQuery.getColumnIndex("frequency")));
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().aL(rawQuery.getInt(rawQuery.getColumnIndex("fans_switch")) == 1);
                        if (rawQuery.getInt(rawQuery.getColumnIndex("reply_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aJ(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aJ(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("at_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aK(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aK(true);
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().dd(rawQuery.getInt(rawQuery.getColumnIndex("remind_tone")));
                        if (rawQuery.getInt(rawQuery.getColumnIndex("msg_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().az(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().az(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("nodisturb_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aD(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aD(true);
                        }
                        String string = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_start_time"));
                        if (TextUtils.isEmpty(string)) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().dY(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().dY(string);
                        }
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_end_time"));
                        if (TextUtils.isEmpty(string2)) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().dZ(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().dZ(string2);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("remind_light")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aF(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aF(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("stranger_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aC(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.c.xe().aC(true);
                        }
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().dc(300);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().aL(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().aJ(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().aK(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().aG(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().aE(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().aF(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().aC(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().az(true);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().aD(false);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().dY(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        com.baidu.tbadk.coreExtra.messageCenter.c.xe().dZ(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    }
                    com.baidu.adp.lib.g.a.b(rawQuery);
                } catch (Exception e) {
                    mainDBDatabaseManager.a(e, "getSettingData");
                    com.baidu.adp.lib.g.a.b((Cursor) null);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_SETTING_READ_FINISH));
            } catch (Throwable th) {
                com.baidu.adp.lib.g.a.b((Cursor) null);
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
