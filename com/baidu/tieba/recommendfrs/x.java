package com.baidu.tieba.recommendfrs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {
    final /* synthetic */ q dVL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(q qVar) {
        this.dVL = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dVL.hideTip();
    }
}
