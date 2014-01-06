package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class dh implements Runnable {
    final /* synthetic */ dg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(dg dgVar) {
        this.a = dgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dx dxVar;
        ed edVar;
        dx dxVar2;
        dxVar = this.a.e.ai;
        if (dxVar != null) {
            dxVar2 = this.a.e.ai;
            dxVar2.a(this.a.a);
        }
        if (this.a.b) {
            edVar = this.a.e.r;
            edVar.a(this.a.c, this.a.d);
        }
        this.a.e.al();
    }
}
