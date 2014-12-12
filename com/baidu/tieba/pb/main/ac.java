package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bq bqVar;
        bq bqVar2;
        bqVar = this.bzj.byJ;
        if (bqVar != null) {
            bqVar2 = this.bzj.byJ;
            bqVar2.LoadData();
        }
    }
}
