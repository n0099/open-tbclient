package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bq bqVar;
        bq bqVar2;
        bqVar = this.bAS.bAr;
        if (bqVar != null) {
            bqVar2 = this.bAS.bAr;
            bqVar2.LoadData();
        }
    }
}
