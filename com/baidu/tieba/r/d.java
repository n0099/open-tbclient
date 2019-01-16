package com.baidu.tieba.r;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.aa;
/* loaded from: classes.dex */
public class d {
    public static void bHM() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new aa());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
