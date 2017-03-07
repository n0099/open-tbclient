package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class be implements Runnable {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel pbModel2;
        pbModel = this.elO.ejZ;
        if (pbModel != null) {
            pbModel2 = this.elO.ejZ;
            pbModel2.LoadData();
        }
    }
}
