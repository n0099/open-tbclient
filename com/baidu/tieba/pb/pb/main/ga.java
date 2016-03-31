package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class ga implements Runnable {
    final /* synthetic */ fy dnj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ga(fy fyVar) {
        this.dnj = fyVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        eu euVar;
        com.baidu.adp.lib.guide.d dVar;
        eu euVar2;
        com.baidu.adp.lib.guide.d dVar2;
        euVar = this.dnj.dnc;
        dVar = euVar.dmO;
        if (dVar != null) {
            euVar2 = this.dnj.dnc;
            dVar2 = euVar2.dmO;
            dVar2.dismiss();
        }
    }
}
