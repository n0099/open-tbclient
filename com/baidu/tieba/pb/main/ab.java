package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        bn bnVar2;
        bnVar = this.bvu.buU;
        if (bnVar != null) {
            bnVar2 = this.bvu.buU;
            bnVar2.LoadData();
        }
    }
}
