package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class bf implements Runnable {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel pbModel2;
        pbModel = this.ehy.efE;
        if (pbModel != null) {
            pbModel2 = this.ehy.efE;
            pbModel2.LoadData();
        }
    }
}
