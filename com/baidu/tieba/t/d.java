package com.baidu.tieba.t;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.ag;
/* loaded from: classes2.dex */
public class d {
    public static void dzr() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new ag());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
