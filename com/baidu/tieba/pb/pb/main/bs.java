package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements Runnable {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dPF.bBB = System.currentTimeMillis();
    }
}
