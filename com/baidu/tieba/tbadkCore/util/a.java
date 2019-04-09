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
    private static Boolean iIv = true;
    private static Boolean iIw = true;

    public static void CF(String str) {
        aE(13, str);
    }

    public static void cfe() {
        zx(2);
    }

    private static void zx(int i) {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().f("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkCoreApplication.getCurrentAccount()});
        }
    }

    private static void aE(int i, String str) {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().f("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
    }

    public static ArrayList<String> cff() {
        return zy(0);
    }

    public static ArrayList<String> cfg() {
        return zy(1);
    }

    private static ArrayList<String> zy(int i) {
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
            mainDBDatabaseManager.c(e, "getAllSearchData");
        } finally {
            com.baidu.adp.lib.g.a.e(cursor);
        }
        return arrayList;
    }

    public static void CG(String str) {
        aF(0, str);
    }

    public static void CH(String str) {
        aF(1, str);
    }

    private static void aF(int i, String str) {
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

    public static void CI(String str) {
        aG(0, str);
    }

    private static void aG(int i, String str) {
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

    public static void cfh() {
        zz(0);
    }

    public static void cfi() {
        zz(1);
    }

    public static void zz(int i) {
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

    public static ArrayList<MarkData> cfj() {
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
                        mainDBDatabaseManager.c(e, "getAllMarkData");
                        com.baidu.adp.lib.g.a.e(cursor);
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.g.a.e(cursor);
                    throw th;
                }
            }
            j(false);
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

    public static void j(Boolean bool) {
        iIv = bool;
    }

    public static void aif() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.f("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
            Object[] objArr = new Object[13];
            objArr[0] = TbadkCoreApplication.getCurrentAccount();
            objArr[1] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aih());
            objArr[2] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aik() ? 1 : 0);
            objArr[3] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.aie().ail() ? 1 : 0);
            objArr[4] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aij() ? 1 : 0);
            objArr[5] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aix());
            objArr[6] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aim() ? 1 : 0);
            objArr[7] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aip() ? 1 : 0);
            objArr[8] = com.baidu.tbadk.coreExtra.messageCenter.d.aie().air();
            objArr[9] = com.baidu.tbadk.coreExtra.messageCenter.d.aie().ais();
            objArr[10] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aio() ? 1 : 0);
            objArr[11] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aii() ? 1 : 0);
            objArr[12] = Integer.valueOf(com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiv() ? 1 : 0);
            mainDBDatabaseManager.f("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch,zan_me_switch) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", objArr);
        }
    }

    public static void cfk() {
        if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().length() > 0 && TbadkCoreApplication.getCurrentAccountName() != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                try {
                    Cursor rawQuery = mainDBDatabaseManager.rawQuery("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                    if (rawQuery != null && rawQuery.moveToFirst()) {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().iD(rawQuery.getInt(rawQuery.getColumnIndex("frequency")));
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().el(rawQuery.getInt(rawQuery.getColumnIndex("fans_switch")) == 1);
                        if (rawQuery.getInt(rawQuery.getColumnIndex("reply_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ej(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ej(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("at_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ek(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ek(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("zan_me_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ec(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ec(true);
                        }
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().iE(rawQuery.getInt(rawQuery.getColumnIndex("remind_tone")));
                        if (rawQuery.getInt(rawQuery.getColumnIndex("msg_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ea(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ea(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("nodisturb_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ee(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ee(true);
                        }
                        String string = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_start_time"));
                        if (TextUtils.isEmpty(string)) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().nM(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().nM(string);
                        }
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("nodisturb_end_time"));
                        if (TextUtils.isEmpty(string2)) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().nN(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().nN(string2);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("remind_light")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().eg(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().eg(true);
                        }
                        if (rawQuery.getInt(rawQuery.getColumnIndex("stranger_chat_switch")) == 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ed(false);
                        } else {
                            com.baidu.tbadk.coreExtra.messageCenter.d.aie().ed(true);
                        }
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().iD(300);
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().el(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().ej(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().ek(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().ec(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().eh(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().ef(false);
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().eg(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().ed(false);
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().ea(true);
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().ee(false);
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().nM(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                        com.baidu.tbadk.coreExtra.messageCenter.d.aie().nN(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    }
                    com.baidu.adp.lib.g.a.e(rawQuery);
                } catch (Exception e) {
                    mainDBDatabaseManager.c(e, "getSettingData");
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
