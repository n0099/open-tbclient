package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements Runnable {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.djE.bfp = System.currentTimeMillis();
    }
}
