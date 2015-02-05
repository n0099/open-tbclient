package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bAS.bAw;
        if (!bzVar.YJ()) {
            bzVar3 = this.bAS.bAw;
            bzVar3.dX(false);
            return;
        }
        bzVar2 = this.bAS.bAw;
        bzVar2.dX(true);
    }
}
