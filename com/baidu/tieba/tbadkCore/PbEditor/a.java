package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.be;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String aEC() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String aED() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean aEE() {
        return !be.c(new Date(System.currentTimeMillis()), new Date(b.tJ().getLong(aED(), 0L))) || b.tJ().getInt(aEC(), 0) < 3;
    }

    public static void aEF() {
        b.tJ().putBoolean("key_baobao_tip_pb", true);
    }

    public static void aEG() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.tJ().getLong(aED(), 0L);
        b.tJ().putLong(aED(), currentTimeMillis);
        int i = b.tJ().getInt(aEC(), 0);
        if (be.c(new Date(currentTimeMillis), new Date(j))) {
            b.tJ().putInt(aEC(), i + 1);
        } else {
            b.tJ().putInt(aEC(), 1);
        }
    }
}
