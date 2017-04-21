package com.baidu.tieba;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j aQk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aQk = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar;
        LogoActivity logoActivity;
        iVar = this.aQk.aQj;
        logoActivity = iVar.aQi;
        logoActivity.JV();
    }
}
