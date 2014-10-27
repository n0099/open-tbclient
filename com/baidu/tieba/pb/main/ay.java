package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements Runnable {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bvg.ayT = System.currentTimeMillis();
    }
}
