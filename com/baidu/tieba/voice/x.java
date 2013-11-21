package com.baidu.tieba.voice;
/* loaded from: classes.dex */
class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2632a;
    final /* synthetic */ v b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar, String str) {
        this.b = vVar;
        this.f2632a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.c.H = 1;
        this.b.c.f2590a.a(this.f2632a, this.b.b);
    }
}
