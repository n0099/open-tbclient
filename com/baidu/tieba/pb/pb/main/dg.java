package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class dg implements Runnable {
    final /* synthetic */ de epf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(de deVar) {
        this.epf = deVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        dd ddVar;
        com.baidu.adp.lib.guide.d dVar;
        dd ddVar2;
        com.baidu.adp.lib.guide.d dVar2;
        ddVar = this.epf.epe;
        dVar = ddVar.epb;
        if (dVar != null) {
            ddVar2 = this.epf.epe;
            dVar2 = ddVar2.epb;
            dVar2.dismiss();
        }
    }
}
