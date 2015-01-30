package com.baidu.tieba.screenlocknotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f bOk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.bOk = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bOk.bOc.acN();
    }
}
