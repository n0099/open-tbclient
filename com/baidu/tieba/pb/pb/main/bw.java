package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Runnable {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eah.dXn = System.currentTimeMillis();
    }
}
