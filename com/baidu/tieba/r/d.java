package com.baidu.tieba.r;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.ac;
/* loaded from: classes.dex */
public class d {
    public static void cpv() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new ac());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
