package com.baidu.tieba;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ LogoActivity aHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LogoActivity logoActivity) {
        this.aHJ = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aHJ.HW();
    }
}
