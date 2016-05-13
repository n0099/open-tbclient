package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.bf;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String aTh() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String aTi() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean aTj() {
        return !bf.c(new Date(System.currentTimeMillis()), new Date(b.sR().getLong(aTi(), 0L))) || b.sR().getInt(aTh(), 0) < 3;
    }

    public static void aTk() {
        b.sR().putBoolean("key_baobao_tip_pb", true);
    }

    public static void aTl() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.sR().getLong(aTi(), 0L);
        b.sR().putLong(aTi(), currentTimeMillis);
        int i = b.sR().getInt(aTh(), 0);
        if (bf.c(new Date(currentTimeMillis), new Date(j))) {
            b.sR().putInt(aTh(), i + 1);
        } else {
            b.sR().putInt(aTh(), 1);
        }
    }
}
