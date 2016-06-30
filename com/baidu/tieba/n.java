package com.baidu.tieba;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ LogoActivity aHs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LogoActivity logoActivity) {
        this.aHs = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aHs.HN();
    }
}
