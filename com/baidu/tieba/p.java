package com.baidu.tieba;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ LogoActivity aQg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(LogoActivity logoActivity) {
        this.aQg = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aQg.JU();
    }
}
