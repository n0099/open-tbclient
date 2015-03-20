package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements Runnable {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bIv.praiseStopTime = System.currentTimeMillis();
    }
}
