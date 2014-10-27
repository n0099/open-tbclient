package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        bn bnVar2;
        bnVar = this.bvg.buG;
        if (bnVar != null) {
            bnVar2 = this.bvg.buG;
            bnVar2.LoadData();
        }
    }
}
