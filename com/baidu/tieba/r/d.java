package com.baidu.tieba.r;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.ab;
/* loaded from: classes.dex */
public class d {
    public static void crd() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new ab());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
