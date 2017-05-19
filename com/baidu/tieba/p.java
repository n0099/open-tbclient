package com.baidu.tieba;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ LogoActivity aQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(LogoActivity logoActivity) {
        this.aQB = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aQB.Ji();
    }
}
