package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class be implements Runnable {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbModel pbModel;
        PbModel pbModel2;
        pbModel = this.emk.ekv;
        if (pbModel != null) {
            pbModel2 = this.emk.ekv;
            pbModel2.LoadData();
        }
    }
}
