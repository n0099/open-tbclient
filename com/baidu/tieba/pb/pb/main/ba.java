package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements Runnable {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cCm.aYp = System.currentTimeMillis();
    }
}
