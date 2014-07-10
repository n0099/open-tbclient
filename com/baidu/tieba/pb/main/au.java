package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements Runnable {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.N = System.currentTimeMillis();
    }
}
