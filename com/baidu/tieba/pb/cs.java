package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ co f2106a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(co coVar) {
        this.f2106a = coVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dd ddVar;
        dd ddVar2;
        ddVar = this.f2106a.f2102a.E;
        ddVar.f();
        ddVar2 = this.f2106a.f2102a.E;
        ddVar2.d();
    }
}
