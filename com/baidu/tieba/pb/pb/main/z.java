package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        bo boVar2;
        boVar = this.bKT.bKv;
        if (boVar != null) {
            boVar2 = this.bKT.bKv;
            boVar2.LoadData();
        }
    }
}
