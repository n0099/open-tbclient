package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.bg;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String biZ() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bja() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean bjb() {
        return !bg.e(new Date(System.currentTimeMillis()), new Date(b.uh().getLong(bja(), 0L))) || b.uh().getInt(biZ(), 0) < 3;
    }

    public static void bjc() {
        b.uh().putBoolean("key_baobao_tip_pb", true);
    }

    public static void bjd() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.uh().getLong(bja(), 0L);
        b.uh().putLong(bja(), currentTimeMillis);
        int i = b.uh().getInt(biZ(), 0);
        if (bg.e(new Date(currentTimeMillis), new Date(j))) {
            b.uh().putInt(biZ(), i + 1);
        } else {
            b.uh().putInt(biZ(), 1);
        }
    }
}
