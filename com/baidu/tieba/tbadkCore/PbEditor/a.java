package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.bd;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String aLI() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String aLJ() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean aLK() {
        return !bd.c(new Date(System.currentTimeMillis()), new Date(b.uO().getLong(aLJ(), 0L))) || b.uO().getInt(aLI(), 0) < 3;
    }

    public static void aLL() {
        b.uO().putBoolean("key_baobao_tip_pb", true);
    }

    public static void aLM() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.uO().getLong(aLJ(), 0L);
        b.uO().putLong(aLJ(), currentTimeMillis);
        int i = b.uO().getInt(aLI(), 0);
        if (bd.c(new Date(currentTimeMillis), new Date(j))) {
            b.uO().putInt(aLI(), i + 1);
        } else {
            b.uO().putInt(aLI(), 1);
        }
    }
}
