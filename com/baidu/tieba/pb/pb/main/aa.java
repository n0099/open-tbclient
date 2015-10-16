package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bl blVar;
        bl blVar2;
        blVar = this.ciK.cih;
        if (blVar != null) {
            blVar2 = this.ciK.cih;
            blVar2.LoadData();
        }
    }
}
