package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.aw;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String atH() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String atI() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean atJ() {
        return !aw.c(new Date(System.currentTimeMillis()), new Date(b.tx().getLong(atI(), 0L))) || b.tx().getInt(atH(), 0) < 3;
    }

    public static void atK() {
        b.tx().putBoolean("key_baobao_tip_pb", true);
    }

    public static void atL() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.tx().getLong(atI(), 0L);
        b.tx().putLong(atI(), currentTimeMillis);
        int i = b.tx().getInt(atH(), 0);
        if (aw.c(new Date(currentTimeMillis), new Date(j))) {
            b.tx().putInt(atH(), i + 1);
        } else {
            b.tx().putInt(atH(), 1);
        }
    }
}
