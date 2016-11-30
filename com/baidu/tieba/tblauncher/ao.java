package com.baidu.tieba.tblauncher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ ae fGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ae aeVar) {
        this.fGW = aeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.fGW.Hu;
        if (dVar != null) {
            dVar2 = this.fGW.Hu;
            dVar2.dismiss();
        }
    }
}
