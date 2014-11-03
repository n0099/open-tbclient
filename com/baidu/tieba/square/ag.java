package com.baidu.tieba.square;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ aa bNf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(aa aaVar) {
        this.bNf = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        aq aqVar;
        try {
            aqVar = this.bNf.bNa;
            aqVar.Df();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
