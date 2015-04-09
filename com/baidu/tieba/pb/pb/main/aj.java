package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Runnable {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        cjVar = this.bIJ.bIl;
        if (!cjVar.abg()) {
            cjVar3 = this.bIJ.bIl;
            cjVar3.dS(false);
            return;
        }
        cjVar2 = this.bIJ.bIl;
        cjVar2.dS(true);
    }
}
