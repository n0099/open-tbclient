package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        ciVar = this.bIv.bHY;
        if (!ciVar.aaT()) {
            ciVar3 = this.bIv.bHY;
            ciVar3.dU(false);
            return;
        }
        ciVar2 = this.bIv.bHY;
        ciVar2.dU(true);
    }
}
