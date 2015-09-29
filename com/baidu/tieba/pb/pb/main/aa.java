package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bl blVar;
        bl blVar2;
        blVar = this.ciz.chV;
        if (blVar != null) {
            blVar2 = this.ciz.chV;
            blVar2.LoadData();
        }
    }
}
