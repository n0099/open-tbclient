package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class df implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ de f2228a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar) {
        this.f2228a = deVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dx dxVar;
        ed edVar;
        dx dxVar2;
        dxVar = this.f2228a.e.af;
        if (dxVar != null) {
            dxVar2 = this.f2228a.e.af;
            dxVar2.a(this.f2228a.f2227a);
        }
        if (this.f2228a.b) {
            edVar = this.f2228a.e.q;
            edVar.a(this.f2228a.c, this.f2228a.d);
        }
        this.f2228a.e.al();
    }
}
