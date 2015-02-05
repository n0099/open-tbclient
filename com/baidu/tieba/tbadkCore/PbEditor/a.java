package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bl;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String afe() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String aff() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean afg() {
        return !bl.isSameDay(new Date(System.currentTimeMillis()), new Date(com.baidu.tbadk.core.sharedPref.b.oc().getLong(aff(), 0L))) || com.baidu.tbadk.core.sharedPref.b.oc().getInt(afe(), 0) < 3;
    }

    public static boolean afh() {
        return !com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("key_baobao_tip_pb", false);
    }

    public static void afi() {
        com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("key_baobao_tip_pb", true);
    }

    public static void afj() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = com.baidu.tbadk.core.sharedPref.b.oc().getLong(aff(), 0L);
        com.baidu.tbadk.core.sharedPref.b.oc().putLong(aff(), currentTimeMillis);
        int i = com.baidu.tbadk.core.sharedPref.b.oc().getInt(afe(), 0);
        if (bl.isSameDay(new Date(currentTimeMillis), new Date(j))) {
            com.baidu.tbadk.core.sharedPref.b.oc().putInt(afe(), i + 1);
        } else {
            com.baidu.tbadk.core.sharedPref.b.oc().putInt(afe(), 1);
        }
    }
}
