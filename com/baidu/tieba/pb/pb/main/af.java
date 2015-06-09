package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ch chVar;
        chVar = this.bKU.bKA;
        chVar.ef(true);
    }
}
