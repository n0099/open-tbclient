package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ciK.aST = System.currentTimeMillis();
    }
}
