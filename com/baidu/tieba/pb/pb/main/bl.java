package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements Runnable {
    final /* synthetic */ bc cjW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bc bcVar) {
        this.cjW = bcVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        pbActivity = this.cjW.cjN;
        pbActivity.hideProgressBar();
    }
}
