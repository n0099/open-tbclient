package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ca caVar;
        ca caVar2;
        caVar = this.cjN.cjj;
        if (caVar != null) {
            caVar2 = this.cjN.cjj;
            caVar2.LoadData();
        }
    }
}
