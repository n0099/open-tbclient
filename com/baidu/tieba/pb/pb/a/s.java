package com.baidu.tieba.pb.pb.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ e dML;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(e eVar) {
        this.dML = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dML.bBB = System.currentTimeMillis();
    }
}
