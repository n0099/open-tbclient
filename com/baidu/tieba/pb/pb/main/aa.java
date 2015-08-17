package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        bk bkVar2;
        bkVar = this.cbo.caL;
        if (bkVar != null) {
            bkVar2 = this.cbo.caL;
            bkVar2.LoadData();
        }
    }
}
