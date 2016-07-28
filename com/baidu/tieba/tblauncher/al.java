package com.baidu.tieba.tblauncher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ ab foX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ab abVar) {
        this.foX = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.foX.Ff;
        if (dVar != null) {
            dVar2 = this.foX.Ff;
            dVar2.dismiss();
        }
    }
}
