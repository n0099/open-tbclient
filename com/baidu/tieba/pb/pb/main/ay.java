package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements Runnable {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bIv.praiseStopTime = System.currentTimeMillis();
    }
}
