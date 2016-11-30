package com.baidu.tieba.imMessageCenter.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ w dzy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.dzy = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dzy.bgv.kv();
    }
}
