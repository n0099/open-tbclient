package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        bo boVar2;
        boVar = this.bKU.bKw;
        if (boVar != null) {
            boVar2 = this.bKU.bKw;
            boVar2.LoadData();
        }
    }
}
