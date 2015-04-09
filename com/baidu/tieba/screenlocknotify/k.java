package com.baidu.tieba.screenlocknotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f bYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.bYV = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bYV.bYM.afY();
    }
}
