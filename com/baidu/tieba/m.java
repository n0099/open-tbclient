package com.baidu.tieba;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ LogoActivity aGQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LogoActivity logoActivity) {
        this.aGQ = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aGQ.HL();
    }
}
