package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements Runnable {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bAS.praiseStopTime = System.currentTimeMillis();
    }
}
