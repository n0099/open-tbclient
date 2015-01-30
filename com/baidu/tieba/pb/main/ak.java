package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bAT.bAx;
        if (!bzVar.YO()) {
            bzVar3 = this.bAT.bAx;
            bzVar3.dX(false);
            return;
        }
        bzVar2 = this.bAT.bAx;
        bzVar2.dX(true);
    }
}
