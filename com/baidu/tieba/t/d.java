package com.baidu.tieba.t;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.ae;
/* loaded from: classes.dex */
public class d {
    public static void cYW() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new ae());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
