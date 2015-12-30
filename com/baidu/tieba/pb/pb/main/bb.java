package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements Runnable {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cFS.bco = System.currentTimeMillis();
    }
}
