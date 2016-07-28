package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.bh;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    private static String beJ() {
        return "key_baobao_count" + TbadkCoreApplication.getCurrentAccount();
    }

    private static String beK() {
        return "key_baobao_last_time" + TbadkCoreApplication.getCurrentAccount();
    }

    public static boolean beL() {
        return !bh.e(new Date(System.currentTimeMillis()), new Date(b.sN().getLong(beK(), 0L))) || b.sN().getInt(beJ(), 0) < 3;
    }

    public static void beM() {
        b.sN().putBoolean("key_baobao_tip_pb", true);
    }

    public static void beN() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = b.sN().getLong(beK(), 0L);
        b.sN().putLong(beK(), currentTimeMillis);
        int i = b.sN().getInt(beJ(), 0);
        if (bh.e(new Date(currentTimeMillis), new Date(j))) {
            b.sN().putInt(beJ(), i + 1);
        } else {
            b.sN().putInt(beJ(), 1);
        }
    }
}
