package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class af implements Runnable {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cc ccVar;
        cc ccVar2;
        ccVar = this.cCm.cBG;
        if (ccVar != null) {
            ccVar2 = this.cCm.cBG;
            ccVar2.LoadData();
        }
    }
}
