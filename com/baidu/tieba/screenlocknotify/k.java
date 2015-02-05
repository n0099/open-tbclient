package com.baidu.tieba.screenlocknotify;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f bOj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.bOj = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bOj.bOb.acI();
    }
}
