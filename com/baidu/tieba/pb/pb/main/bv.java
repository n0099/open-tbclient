package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eqa.epA = System.currentTimeMillis();
    }
}
