package com.baidu.tieba.screenlocknotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f bMA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.bMA = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bMA.bMs.acj();
    }
}
