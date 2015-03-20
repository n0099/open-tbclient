package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bq bqVar;
        bq bqVar2;
        bqVar = this.bIv.bHT;
        if (bqVar != null) {
            bqVar2 = this.bIv.bHT;
            bqVar2.LoadData();
        }
    }
}
