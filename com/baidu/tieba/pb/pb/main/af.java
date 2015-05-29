package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ch chVar;
        chVar = this.bKT.bKz;
        chVar.ef(true);
    }
}
