package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.aw;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String apu() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String apv() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean apw() {
        return !aw.c(new Date(System.currentTimeMillis()), new Date(b.ts().getLong(apv(), 0L))) || b.ts().getInt(apu(), 0) < 3;
    }

    public static void apx() {
        b.ts().putBoolean("key_baobao_tip_pb", true);
    }

    public static void apy() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.ts().getLong(apv(), 0L);
        b.ts().putLong(apv(), currentTimeMillis);
        int i = b.ts().getInt(apu(), 0);
        if (aw.c(new Date(currentTimeMillis), new Date(j))) {
            b.ts().putInt(apu(), i + 1);
        } else {
            b.ts().putInt(apu(), 1);
        }
    }
}
