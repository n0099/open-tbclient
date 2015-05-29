package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bKT.praiseStopTime = System.currentTimeMillis();
    }
}
