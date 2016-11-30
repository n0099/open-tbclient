package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements Runnable {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.evL.esR = System.currentTimeMillis();
    }
}
