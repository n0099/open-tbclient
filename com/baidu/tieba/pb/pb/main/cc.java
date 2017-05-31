package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements Runnable {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.enc.emA = System.currentTimeMillis();
    }
}
