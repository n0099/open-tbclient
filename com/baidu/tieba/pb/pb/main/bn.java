package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements Runnable {
    final /* synthetic */ be cCv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(be beVar) {
        this.cCv = beVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbActivity pbActivity;
        pbActivity = this.cCv.cCm;
        pbActivity.hideProgressBar();
    }
}
