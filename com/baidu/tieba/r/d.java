package com.baidu.tieba.r;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.z;
/* loaded from: classes.dex */
public class d {
    public static void bHd() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new z());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
