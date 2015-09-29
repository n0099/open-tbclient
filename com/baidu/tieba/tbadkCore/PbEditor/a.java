package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ax;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String avX() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String avY() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean avZ() {
        return !ax.c(new Date(System.currentTimeMillis()), new Date(b.tu().getLong(avY(), 0L))) || b.tu().getInt(avX(), 0) < 3;
    }

    public static void awa() {
        b.tu().putBoolean("key_baobao_tip_pb", true);
    }

    public static void awb() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.tu().getLong(avY(), 0L);
        b.tu().putLong(avY(), currentTimeMillis);
        int i = b.tu().getInt(avX(), 0);
        if (ax.c(new Date(currentTimeMillis), new Date(j))) {
            b.tu().putInt(avX(), i + 1);
        } else {
            b.tu().putInt(avX(), 1);
        }
    }
}
