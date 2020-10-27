package com.baidu.tieba.t;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.ah;
/* loaded from: classes.dex */
public class d {
    public static void dKo() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new ah());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
