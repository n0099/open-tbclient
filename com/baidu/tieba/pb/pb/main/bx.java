package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements Runnable {
    final /* synthetic */ bo cNE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bo boVar) {
        this.cNE = boVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        pbActivity = this.cNE.cNq;
        pbActivity.hideProgressBar();
    }
}
