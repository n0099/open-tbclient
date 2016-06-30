package com.baidu.tieba.imMessageCenter.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ w ddU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.ddU = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ddU.aWk.jB();
    }
}
