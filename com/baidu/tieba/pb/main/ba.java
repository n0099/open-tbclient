package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements Runnable {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bzj.praiseStopTime = System.currentTimeMillis();
    }
}
