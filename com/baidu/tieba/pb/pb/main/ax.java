package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements Runnable {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bKT.praiseStopTime = System.currentTimeMillis();
    }
}
