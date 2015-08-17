package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cbo.aTy = System.currentTimeMillis();
    }
}
