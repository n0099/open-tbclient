package com.baidu.tieba;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
        this.a.j();
    }
}
