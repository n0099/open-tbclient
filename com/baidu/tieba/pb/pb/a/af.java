package com.baidu.tieba.pb.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ r dgC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(r rVar) {
        this.dgC = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dgC.bfp = System.currentTimeMillis();
    }
}
