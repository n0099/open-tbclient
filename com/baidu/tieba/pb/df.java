package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class df implements Runnable {
    final /* synthetic */ de a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar) {
        this.a = deVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dx dxVar;
        ed edVar;
        dx dxVar2;
        dxVar = this.a.e.af;
        if (dxVar != null) {
            dxVar2 = this.a.e.af;
            dxVar2.a(this.a.a);
        }
        if (this.a.b) {
            edVar = this.a.e.q;
            edVar.a(this.a.c, this.a.d);
        }
        this.a.e.al();
    }
}
