package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class ao implements Runnable {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cm cmVar;
        cm cmVar2;
        cmVar = this.cNq.cMF;
        if (cmVar != null) {
            cmVar2 = this.cNq.cMF;
            cmVar2.LoadData();
        }
    }
}
