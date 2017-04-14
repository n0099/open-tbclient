package com.baidu.tieba;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j aQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aQi = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar;
        LogoActivity logoActivity;
        iVar = this.aQi.aQh;
        logoActivity = iVar.aQg;
        logoActivity.JV();
    }
}
