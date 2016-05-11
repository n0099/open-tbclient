package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class cv implements Runnable {
    final /* synthetic */ ct dkU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(ct ctVar) {
        this.dkU = ctVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cs csVar;
        com.baidu.adp.lib.guide.d dVar;
        cs csVar2;
        com.baidu.adp.lib.guide.d dVar2;
        csVar = this.dkU.dkT;
        dVar = csVar.dkQ;
        if (dVar != null) {
            csVar2 = this.dkU.dkT;
            dVar2 = csVar2.dkQ;
            dVar2.dismiss();
        }
    }
}
