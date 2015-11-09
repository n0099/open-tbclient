package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ay;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String awJ() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String awK() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean awL() {
        return !ay.c(new Date(System.currentTimeMillis()), new Date(b.tu().getLong(awK(), 0L))) || b.tu().getInt(awJ(), 0) < 3;
    }

    public static void awM() {
        b.tu().putBoolean("key_baobao_tip_pb", true);
    }

    public static void awN() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.tu().getLong(awK(), 0L);
        b.tu().putLong(awK(), currentTimeMillis);
        int i = b.tu().getInt(awJ(), 0);
        if (ay.c(new Date(currentTimeMillis), new Date(j))) {
            b.tu().putInt(awJ(), i + 1);
        } else {
            b.tu().putInt(awJ(), 1);
        }
    }
}
