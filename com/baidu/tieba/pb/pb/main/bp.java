package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class bp implements Runnable {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel pbModel2;
        pbModel = this.ewh.eue;
        if (pbModel != null) {
            pbModel2 = this.ewh.eue;
            pbModel2.LoadData();
        }
    }
}
