package com.baidu.tieba.recommendfrs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ n doE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.doE = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.doE.hideTip();
    }
}
