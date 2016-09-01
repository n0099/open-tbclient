package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Runnable {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eob.ekS = System.currentTimeMillis();
    }
}
