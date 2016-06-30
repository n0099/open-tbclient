package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.bh;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String bbu() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String bbv() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean bbw() {
        return !bh.e(new Date(System.currentTimeMillis()), new Date(b.sO().getLong(bbv(), 0L))) || b.sO().getInt(bbu(), 0) < 3;
    }

    public static void bbx() {
        b.sO().putBoolean("key_baobao_tip_pb", true);
    }

    public static void bby() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.sO().getLong(bbv(), 0L);
        b.sO().putLong(bbv(), currentTimeMillis);
        int i = b.sO().getInt(bbu(), 0);
        if (bh.e(new Date(currentTimeMillis), new Date(j))) {
            b.sO().putInt(bbu(), i + 1);
        } else {
            b.sO().putInt(bbu(), 1);
        }
    }
}
