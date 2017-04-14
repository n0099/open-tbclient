package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class be implements Runnable {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel pbModel2;
        pbModel = this.ejU.eif;
        if (pbModel != null) {
            pbModel2 = this.ejU.eif;
            pbModel2.LoadData();
        }
    }
}
