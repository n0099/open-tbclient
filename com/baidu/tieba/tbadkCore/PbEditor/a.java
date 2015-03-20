package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bj;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String akT() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String akU() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean akV() {
        return !bj.isSameDay(new Date(System.currentTimeMillis()), new Date(com.baidu.tbadk.core.sharedPref.b.rB().getLong(akU(), 0L))) || com.baidu.tbadk.core.sharedPref.b.rB().getInt(akT(), 0) < 3;
    }

    public static boolean akW() {
        return !com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("key_baobao_tip_pb", false);
    }

    public static void akX() {
        com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("key_baobao_tip_pb", true);
    }

    public static void akY() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = com.baidu.tbadk.core.sharedPref.b.rB().getLong(akU(), 0L);
        com.baidu.tbadk.core.sharedPref.b.rB().putLong(akU(), currentTimeMillis);
        int i = com.baidu.tbadk.core.sharedPref.b.rB().getInt(akT(), 0);
        if (bj.isSameDay(new Date(currentTimeMillis), new Date(j))) {
            com.baidu.tbadk.core.sharedPref.b.rB().putInt(akT(), i + 1);
        } else {
            com.baidu.tbadk.core.sharedPref.b.rB().putInt(akT(), 1);
        }
    }
}
