package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        bk bkVar2;
        bkVar = this.ccj.cbG;
        if (bkVar != null) {
            bkVar2 = this.ccj.cbG;
            bkVar2.LoadData();
        }
    }
}
