package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class di implements Runnable {
    final /* synthetic */ dg ewV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dg dgVar) {
        this.ewV = dgVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        df dfVar;
        com.baidu.adp.lib.guide.d dVar;
        df dfVar2;
        com.baidu.adp.lib.guide.d dVar2;
        dfVar = this.ewV.ewU;
        dVar = dfVar.ewQ;
        if (dVar != null) {
            dfVar2 = this.ewV.ewU;
            dVar2 = dfVar2.ewQ;
            dVar2.dismiss();
        }
    }
}
