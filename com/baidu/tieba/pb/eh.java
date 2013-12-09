package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class eh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ eg f2255a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(eg egVar) {
        this.f2255a = egVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2255a.d.f2253a.c(this.f2255a.f2254a);
        this.f2255a.d.f2253a.a(this.f2255a.b, this.f2255a.c);
    }
}
