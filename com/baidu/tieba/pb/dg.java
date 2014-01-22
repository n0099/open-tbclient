package com.baidu.tieba.pb;
/* loaded from: classes.dex */
class dg implements Runnable {
    final /* synthetic */ df a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(df dfVar) {
        this.a = dfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dv dvVar;
        eb ebVar;
        dv dvVar2;
        dvVar = this.a.e.ah;
        if (dvVar != null) {
            dvVar2 = this.a.e.ah;
            dvVar2.a(this.a.a);
        }
        if (this.a.b) {
            ebVar = this.a.e.r;
            ebVar.a(this.a.c, this.a.d);
        }
        this.a.e.al();
    }
}
