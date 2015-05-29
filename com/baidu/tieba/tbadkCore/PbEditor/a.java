package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bh;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String amT() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String amU() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean amV() {
        return !bh.isSameDay(new Date(System.currentTimeMillis()), new Date(com.baidu.tbadk.core.sharedPref.b.sl().getLong(amU(), 0L))) || com.baidu.tbadk.core.sharedPref.b.sl().getInt(amT(), 0) < 3;
    }

    public static boolean amW() {
        return !com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("key_baobao_tip_pb", false);
    }

    public static void amX() {
        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("key_baobao_tip_pb", true);
    }

    public static void amY() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = com.baidu.tbadk.core.sharedPref.b.sl().getLong(amU(), 0L);
        com.baidu.tbadk.core.sharedPref.b.sl().putLong(amU(), currentTimeMillis);
        int i = com.baidu.tbadk.core.sharedPref.b.sl().getInt(amT(), 0);
        if (bh.isSameDay(new Date(currentTimeMillis), new Date(j))) {
            com.baidu.tbadk.core.sharedPref.b.sl().putInt(amT(), i + 1);
        } else {
            com.baidu.tbadk.core.sharedPref.b.sl().putInt(amT(), 1);
        }
    }
}
