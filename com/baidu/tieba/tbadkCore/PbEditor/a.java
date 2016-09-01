package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.bh;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String bio() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bip() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean biq() {
        return !bh.e(new Date(System.currentTimeMillis()), new Date(b.tS().getLong(bip(), 0L))) || b.tS().getInt(bio(), 0) < 3;
    }

    public static void bir() {
        b.tS().putBoolean("key_baobao_tip_pb", true);
    }

    public static void bis() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.tS().getLong(bip(), 0L);
        b.tS().putLong(bip(), currentTimeMillis);
        int i = b.tS().getInt(bio(), 0);
        if (bh.e(new Date(currentTimeMillis), new Date(j))) {
            b.tS().putInt(bio(), i + 1);
        } else {
            b.tS().putInt(bio(), 1);
        }
    }
}
