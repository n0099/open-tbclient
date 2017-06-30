package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements Runnable {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ewh.evE = System.currentTimeMillis();
    }
}
