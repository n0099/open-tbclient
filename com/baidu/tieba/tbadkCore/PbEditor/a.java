package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ay;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String awb() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String awc() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean awd() {
        return !ay.c(new Date(System.currentTimeMillis()), new Date(b.tr().getLong(awc(), 0L))) || b.tr().getInt(awb(), 0) < 3;
    }

    public static void awe() {
        b.tr().putBoolean("key_baobao_tip_pb", true);
    }

    public static void awf() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.tr().getLong(awc(), 0L);
        b.tr().putLong(awc(), currentTimeMillis);
        int i = b.tr().getInt(awb(), 0);
        if (ay.c(new Date(currentTimeMillis), new Date(j))) {
            b.tr().putInt(awb(), i + 1);
        } else {
            b.tr().putInt(awb(), 1);
        }
    }
}
