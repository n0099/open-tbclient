package com.baidu.tieba;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ LogoActivity aRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LogoActivity logoActivity) {
        this.aRW = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aRW.JD();
    }
}
