package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eob.ekS = System.currentTimeMillis();
    }
}
