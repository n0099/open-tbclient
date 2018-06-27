package com.baidu.tieba.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.y;
/* loaded from: classes.dex */
public class b {
    public static void bAd() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new y());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
