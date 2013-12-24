package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class eh implements Runnable {
    final /* synthetic */ eg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(eg egVar) {
        this.a = egVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.d.a.c(this.a.a);
        this.a.d.a.a(this.a.b, this.a.c);
    }
}
