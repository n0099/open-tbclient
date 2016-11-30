package com.baidu.tieba;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ LogoActivity aLM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.aLM = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aLM.Ji();
    }
}
