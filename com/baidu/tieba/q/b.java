package com.baidu.tieba.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.x;
/* loaded from: classes.dex */
public class b {
    public static void byG() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new x());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
