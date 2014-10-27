package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Runnable {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bvVar = this.bvg.buL;
        if (!bvVar.XJ()) {
            bvVar3 = this.bvg.buL;
            bvVar3.eg(false);
            return;
        }
        bvVar2 = this.bvg.buL;
        bvVar2.eg(true);
    }
}
