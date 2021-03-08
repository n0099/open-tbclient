package com.baidu.tieba.t;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.ai;
/* loaded from: classes.dex */
public class d {
    public static void dRe() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new ai());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
