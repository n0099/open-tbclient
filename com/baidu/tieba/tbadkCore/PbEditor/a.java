package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.bf;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String aTb() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String aTc() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean aTd() {
        return !bf.c(new Date(System.currentTimeMillis()), new Date(b.sQ().getLong(aTc(), 0L))) || b.sQ().getInt(aTb(), 0) < 3;
    }

    public static void aTe() {
        b.sQ().putBoolean("key_baobao_tip_pb", true);
    }

    public static void aTf() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.sQ().getLong(aTc(), 0L);
        b.sQ().putLong(aTc(), currentTimeMillis);
        int i = b.sQ().getInt(aTb(), 0);
        if (bf.c(new Date(currentTimeMillis), new Date(j))) {
            b.sQ().putInt(aTb(), i + 1);
        } else {
            b.sQ().putInt(aTb(), 1);
        }
    }
}
