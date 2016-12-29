package com.baidu.tieba;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ LogoActivity aLd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.aLd = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aLd.ID();
    }
}
