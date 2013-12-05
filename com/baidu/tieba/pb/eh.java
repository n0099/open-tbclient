package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class eh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ eg f2254a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(eg egVar) {
        this.f2254a = egVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2254a.d.f2252a.c(this.f2254a.f2253a);
        this.f2254a.d.f2252a.a(this.f2254a.b, this.f2254a.c);
    }
}
