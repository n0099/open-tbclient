package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class df implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ de f2121a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar) {
        this.f2121a = deVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dx dxVar;
        ed edVar;
        dx dxVar2;
        dxVar = this.f2121a.e.af;
        if (dxVar != null) {
            dxVar2 = this.f2121a.e.af;
            dxVar2.a(this.f2121a.f2120a);
        }
        if (this.f2121a.b) {
            edVar = this.f2121a.e.q;
            edVar.a(this.f2121a.c, this.f2121a.d);
        }
        this.f2121a.e.al();
    }
}
