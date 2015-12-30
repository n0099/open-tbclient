package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements Runnable {
    final /* synthetic */ bh cGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bh bhVar) {
        this.cGg = bhVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        pbActivity = this.cGg.cFS;
        pbActivity.hideProgressBar();
    }
}
