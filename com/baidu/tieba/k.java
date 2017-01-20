package com.baidu.tieba;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ LogoActivity aKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.aKf = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aKf.IP();
    }
}
