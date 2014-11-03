package com.baidu.tieba.pb.sub;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ l bAZ;
    private final /* synthetic */ String bBa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar, String str) {
        this.bAZ = lVar;
        this.bBa = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bAZ.hc(this.bBa);
    }
}
