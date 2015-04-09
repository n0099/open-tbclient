package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bj;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String ali() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String alj() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean alk() {
        return !bj.isSameDay(new Date(System.currentTimeMillis()), new Date(com.baidu.tbadk.core.sharedPref.b.rB().getLong(alj(), 0L))) || com.baidu.tbadk.core.sharedPref.b.rB().getInt(ali(), 0) < 3;
    }

    public static boolean all() {
        return !com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("key_baobao_tip_pb", false);
    }

    public static void alm() {
        com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("key_baobao_tip_pb", true);
    }

    public static void aln() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = com.baidu.tbadk.core.sharedPref.b.rB().getLong(alj(), 0L);
        com.baidu.tbadk.core.sharedPref.b.rB().putLong(alj(), currentTimeMillis);
        int i = com.baidu.tbadk.core.sharedPref.b.rB().getInt(ali(), 0);
        if (bj.isSameDay(new Date(currentTimeMillis), new Date(j))) {
            com.baidu.tbadk.core.sharedPref.b.rB().putInt(ali(), i + 1);
        } else {
            com.baidu.tbadk.core.sharedPref.b.rB().putInt(ali(), 1);
        }
    }
}
