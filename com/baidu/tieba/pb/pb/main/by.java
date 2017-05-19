package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements Runnable {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ehy.egX = System.currentTimeMillis();
    }
}
