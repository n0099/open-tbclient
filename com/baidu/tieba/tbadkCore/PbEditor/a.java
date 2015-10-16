package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ay;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String awf() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String awg() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean awh() {
        return !ay.c(new Date(System.currentTimeMillis()), new Date(b.tu().getLong(awg(), 0L))) || b.tu().getInt(awf(), 0) < 3;
    }

    public static void awi() {
        b.tu().putBoolean("key_baobao_tip_pb", true);
    }

    public static void awj() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.tu().getLong(awg(), 0L);
        b.tu().putLong(awg(), currentTimeMillis);
        int i = b.tu().getInt(awf(), 0);
        if (ay.c(new Date(currentTimeMillis), new Date(j))) {
            b.tu().putInt(awf(), i + 1);
        } else {
            b.tu().putInt(awf(), 1);
        }
    }
}
