package com.baidu.tieba.pb.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements Runnable {
    final /* synthetic */ q cKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(q qVar) {
        this.cKS = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cKS.beD = System.currentTimeMillis();
    }
}
