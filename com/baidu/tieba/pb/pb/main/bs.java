package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements Runnable {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ebT.dYO = System.currentTimeMillis();
    }
}
