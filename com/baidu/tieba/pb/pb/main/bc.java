package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements Runnable {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cFS.bco = System.currentTimeMillis();
    }
}
