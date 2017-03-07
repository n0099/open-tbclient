package com.baidu.tieba;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j aPS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.aPS = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVar;
        LogoActivity logoActivity;
        iVar = this.aPS.aPR;
        logoActivity = iVar.aPQ;
        logoActivity.Jv();
    }
}
