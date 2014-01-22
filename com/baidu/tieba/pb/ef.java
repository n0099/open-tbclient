package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class ef implements Runnable {
    final /* synthetic */ ee a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(ee eeVar) {
        this.a = eeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.d.a.c(this.a.a);
        this.a.d.a.a(this.a.b, this.a.c);
    }
}
