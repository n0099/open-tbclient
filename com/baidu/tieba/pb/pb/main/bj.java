package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class bj implements Runnable {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel pbModel2;
        pbModel = this.enc.ele;
        if (pbModel != null) {
            pbModel2 = this.enc.ele;
            pbModel2.LoadData();
        }
    }
}
