package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements Runnable {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cNq.beD = System.currentTimeMillis();
    }
}
