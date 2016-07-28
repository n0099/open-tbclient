package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class dg implements Runnable {
    final /* synthetic */ de eda;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(de deVar) {
        this.eda = deVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dd ddVar;
        com.baidu.adp.lib.guide.d dVar;
        dd ddVar2;
        com.baidu.adp.lib.guide.d dVar2;
        ddVar = this.eda.ecZ;
        dVar = ddVar.ecW;
        if (dVar != null) {
            ddVar2 = this.eda.ecZ;
            dVar2 = ddVar2.ecW;
            dVar2.dismiss();
        }
    }
}
