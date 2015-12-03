package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.be;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String aCv() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String aCw() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean aCx() {
        return !be.c(new Date(System.currentTimeMillis()), new Date(b.tZ().getLong(aCw(), 0L))) || b.tZ().getInt(aCv(), 0) < 3;
    }

    public static void aCy() {
        b.tZ().putBoolean("key_baobao_tip_pb", true);
    }

    public static void aCz() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.tZ().getLong(aCw(), 0L);
        b.tZ().putLong(aCw(), currentTimeMillis);
        int i = b.tZ().getInt(aCv(), 0);
        if (be.c(new Date(currentTimeMillis), new Date(j))) {
            b.tZ().putInt(aCv(), i + 1);
        } else {
            b.tZ().putInt(aCv(), 1);
        }
    }
}
