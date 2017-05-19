package com.baidu.tieba;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j aQD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aQD = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar;
        LogoActivity logoActivity;
        iVar = this.aQD.aQC;
        logoActivity = iVar.aQB;
        logoActivity.Jj();
    }
}
