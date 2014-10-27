package com.baidu.tieba.square;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ aa bMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(aa aaVar) {
        this.bMQ = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        aq aqVar;
        try {
            aqVar = this.bMQ.bML;
            aqVar.Dd();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
