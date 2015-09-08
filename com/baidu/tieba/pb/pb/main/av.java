package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements Runnable {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ccj.aTM = System.currentTimeMillis();
    }
}
