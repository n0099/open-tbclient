package com.baidu.tieba;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ LogoActivity aQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(LogoActivity logoActivity) {
        this.aQi = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aQi.JU();
    }
}
