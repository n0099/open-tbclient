package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bKU.praiseStopTime = System.currentTimeMillis();
    }
}
