package com.baidu.tieba.recommendfrs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ r dYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(r rVar) {
        this.dYM = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dYM.hideTip();
    }
}
