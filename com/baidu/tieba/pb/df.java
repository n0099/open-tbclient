package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class df implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ de f2229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar) {
        this.f2229a = deVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dx dxVar;
        ed edVar;
        dx dxVar2;
        dxVar = this.f2229a.e.af;
        if (dxVar != null) {
            dxVar2 = this.f2229a.e.af;
            dxVar2.a(this.f2229a.f2228a);
        }
        if (this.f2229a.b) {
            edVar = this.f2229a.e.q;
            edVar.a(this.f2229a.c, this.f2229a.d);
        }
        this.f2229a.e.al();
    }
}
