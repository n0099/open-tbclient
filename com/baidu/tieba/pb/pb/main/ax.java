package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements Runnable {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bKU.praiseStopTime = System.currentTimeMillis();
    }
}
