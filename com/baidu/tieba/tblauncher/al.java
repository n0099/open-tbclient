package com.baidu.tieba.tblauncher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ ab fbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ab abVar) {
        this.fbT = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.fbT.EF;
        if (dVar != null) {
            dVar2 = this.fbT.EF;
            dVar2.dismiss();
        }
    }
}
