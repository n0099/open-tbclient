package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements Runnable {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ewh.evE = System.currentTimeMillis();
    }
}
