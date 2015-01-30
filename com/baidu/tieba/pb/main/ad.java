package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bq bqVar;
        bq bqVar2;
        bqVar = this.bAT.bAs;
        if (bqVar != null) {
            bqVar2 = this.bAT.bAs;
            bqVar2.LoadData();
        }
    }
}
