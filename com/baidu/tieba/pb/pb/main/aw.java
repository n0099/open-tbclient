package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ciz.aSI = System.currentTimeMillis();
    }
}
