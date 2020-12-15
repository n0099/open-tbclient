package com.baidu.tieba.u;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.ag;
/* loaded from: classes.dex */
public class d {
    public static void dSi() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new ag());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
