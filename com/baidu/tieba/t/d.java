package com.baidu.tieba.t;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.util.af;
/* loaded from: classes.dex */
public class d {
    public static void dgl() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new af());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
