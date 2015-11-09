package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements Runnable {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cjN.aTb = System.currentTimeMillis();
    }
}
