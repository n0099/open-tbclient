package com.baidu.tieba.voice;
/* loaded from: classes.dex */
class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2649a;
    final /* synthetic */ v b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar, String str) {
        this.b = vVar;
        this.f2649a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.c.H = 1;
        this.b.c.f2607a.a(this.f2649a, this.b.b);
    }
}
