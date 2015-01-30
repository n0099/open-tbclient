package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bl;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String afj() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String afk() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean afl() {
        return !bl.isSameDay(new Date(System.currentTimeMillis()), new Date(com.baidu.tbadk.core.sharedPref.b.oj().getLong(afk(), 0L))) || com.baidu.tbadk.core.sharedPref.b.oj().getInt(afj(), 0) < 3;
    }

    public static boolean afm() {
        return !com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("key_baobao_tip_pb", false);
    }

    public static void afn() {
        com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("key_baobao_tip_pb", true);
    }

    public static void afo() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = com.baidu.tbadk.core.sharedPref.b.oj().getLong(afk(), 0L);
        com.baidu.tbadk.core.sharedPref.b.oj().putLong(afk(), currentTimeMillis);
        int i = com.baidu.tbadk.core.sharedPref.b.oj().getInt(afj(), 0);
        if (bl.isSameDay(new Date(currentTimeMillis), new Date(j))) {
            com.baidu.tbadk.core.sharedPref.b.oj().putInt(afj(), i + 1);
        } else {
            com.baidu.tbadk.core.sharedPref.b.oj().putInt(afj(), 1);
        }
    }
}
