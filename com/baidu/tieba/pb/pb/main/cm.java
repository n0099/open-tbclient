package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements Runnable {
    final /* synthetic */ cl dhJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cl clVar) {
        this.dhJ = clVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        pbActivity = this.dhJ.dht;
        pbActivity.hideProgressBar();
    }
}
