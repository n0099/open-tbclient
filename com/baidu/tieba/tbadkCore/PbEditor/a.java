package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.bf;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String aSC() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String aSD() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean aSE() {
        return !bf.c(new Date(System.currentTimeMillis()), new Date(b.vk().getLong(aSD(), 0L))) || b.vk().getInt(aSC(), 0) < 3;
    }

    public static void aSF() {
        b.vk().putBoolean("key_baobao_tip_pb", true);
    }

    public static void aSG() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.vk().getLong(aSD(), 0L);
        b.vk().putLong(aSD(), currentTimeMillis);
        int i = b.vk().getInt(aSC(), 0);
        if (bf.c(new Date(currentTimeMillis), new Date(j))) {
            b.vk().putInt(aSC(), i + 1);
        } else {
            b.vk().putInt(aSC(), 1);
        }
    }
}
