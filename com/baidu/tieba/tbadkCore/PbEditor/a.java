package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bh;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String amU() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String amV() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean amW() {
        return !bh.isSameDay(new Date(System.currentTimeMillis()), new Date(com.baidu.tbadk.core.sharedPref.b.sl().getLong(amV(), 0L))) || com.baidu.tbadk.core.sharedPref.b.sl().getInt(amU(), 0) < 3;
    }

    public static boolean amX() {
        return !com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("key_baobao_tip_pb", false);
    }

    public static void amY() {
        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("key_baobao_tip_pb", true);
    }

    public static void amZ() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = com.baidu.tbadk.core.sharedPref.b.sl().getLong(amV(), 0L);
        com.baidu.tbadk.core.sharedPref.b.sl().putLong(amV(), currentTimeMillis);
        int i = com.baidu.tbadk.core.sharedPref.b.sl().getInt(amU(), 0);
        if (bh.isSameDay(new Date(currentTimeMillis), new Date(j))) {
            com.baidu.tbadk.core.sharedPref.b.sl().putInt(amU(), i + 1);
        } else {
            com.baidu.tbadk.core.sharedPref.b.sl().putInt(amU(), 1);
        }
    }
}
