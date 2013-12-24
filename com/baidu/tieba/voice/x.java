package com.baidu.tieba.voice;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ v b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar, String str) {
        this.b = vVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.c.H = 1;
        this.b.c.a.a(this.a, this.b.b);
    }
}
