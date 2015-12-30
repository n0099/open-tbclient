package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cf cfVar;
        cf cfVar2;
        cfVar = this.cFS.cFl;
        if (cfVar != null) {
            cfVar2 = this.cFS.cFl;
            cfVar2.LoadData();
        }
    }
}
