package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        br brVar;
        br brVar2;
        brVar = this.bIJ.bIg;
        if (brVar != null) {
            brVar2 = this.bIJ.bIg;
            brVar2.LoadData();
        }
    }
}
