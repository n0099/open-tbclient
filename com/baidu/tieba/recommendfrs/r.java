package com.baidu.tieba.recommendfrs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ p dDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.dDT = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dDT.hideTip();
    }
}
