package com.baidu.tieba.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.z;
/* loaded from: classes.dex */
public class d {
    public static void bEk() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new z());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
