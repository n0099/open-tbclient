package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class bf implements Runnable {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel pbModel2;
        pbModel = this.eiV.ehh;
        if (pbModel != null) {
            pbModel2 = this.eiV.ehh;
            pbModel2.LoadData();
        }
    }
}
