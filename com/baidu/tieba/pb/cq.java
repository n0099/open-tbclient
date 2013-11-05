package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class cq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ co f2104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(co coVar) {
        this.f2104a = coVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dd ddVar;
        dd ddVar2;
        dd ddVar3;
        ddVar = this.f2104a.f2102a.E;
        if (ddVar.l().getVisibility() != 0) {
            ddVar2 = this.f2104a.f2102a.E;
            if (ddVar2.k().getVisibility() != 0) {
                ddVar3 = this.f2104a.f2102a.E;
                ddVar3.m();
            }
        }
    }
}
