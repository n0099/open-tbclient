package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class dd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dc f2136a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(dc dcVar) {
        this.f2136a = dcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dv dvVar;
        eb ebVar;
        dv dvVar2;
        dvVar = this.f2136a.e.af;
        if (dvVar != null) {
            dvVar2 = this.f2136a.e.af;
            dvVar2.a(this.f2136a.f2135a);
        }
        if (this.f2136a.b) {
            ebVar = this.f2136a.e.q;
            ebVar.a(this.f2136a.c, this.f2136a.d);
        }
        this.f2136a.e.al();
    }
}
