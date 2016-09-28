package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class dg implements Runnable {
    final /* synthetic */ de erd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(de deVar) {
        this.erd = deVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dd ddVar;
        com.baidu.adp.lib.guide.d dVar;
        dd ddVar2;
        com.baidu.adp.lib.guide.d dVar2;
        ddVar = this.erd.erc;
        dVar = ddVar.eqZ;
        if (dVar != null) {
            ddVar2 = this.erd.erc;
            dVar2 = ddVar2.eqZ;
            dVar2.dismiss();
        }
    }
}
