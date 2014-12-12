package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bg;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String aeF() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String aeG() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean aeH() {
        return !bg.isSameDay(new Date(System.currentTimeMillis()), new Date(com.baidu.tbadk.core.sharedPref.b.og().getLong(aeG(), 0L))) || com.baidu.tbadk.core.sharedPref.b.og().getInt(aeF(), 0) < 3;
    }

    public static boolean aeI() {
        return !com.baidu.tbadk.core.sharedPref.b.og().getBoolean("key_baobao_tip_pb", false);
    }

    public static void aeJ() {
        com.baidu.tbadk.core.sharedPref.b.og().putBoolean("key_baobao_tip_pb", true);
    }

    public static void aeK() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = com.baidu.tbadk.core.sharedPref.b.og().getLong(aeG(), 0L);
        com.baidu.tbadk.core.sharedPref.b.og().putLong(aeG(), currentTimeMillis);
        int i = com.baidu.tbadk.core.sharedPref.b.og().getInt(aeF(), 0);
        if (bg.isSameDay(new Date(currentTimeMillis), new Date(j))) {
            com.baidu.tbadk.core.sharedPref.b.og().putInt(aeF(), i + 1);
        } else {
            com.baidu.tbadk.core.sharedPref.b.og().putInt(aeF(), 1);
        }
    }
}
