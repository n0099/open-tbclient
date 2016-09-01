package com.baidu.tieba.tblauncher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ac fwR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ac acVar) {
        this.fwR = acVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.fwR.Hs;
        if (dVar != null) {
            dVar2 = this.fwR.Hs;
            dVar2.dismiss();
        }
    }
}
