package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Runnable {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bvVar = this.bvu.buZ;
        if (!bvVar.XM()) {
            bvVar3 = this.bvu.buZ;
            bvVar3.eg(false);
            return;
        }
        bvVar2 = this.bvu.buZ;
        bvVar2.eg(true);
    }
}
