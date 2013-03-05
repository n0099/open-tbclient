package com.baidu.tieba;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
        this.a.j();
    }
}
