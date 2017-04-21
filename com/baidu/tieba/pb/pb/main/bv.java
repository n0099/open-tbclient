package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.emk.elJ = System.currentTimeMillis();
    }
}
