package com.baidu.tieba.imMessageCenter.mention;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ w dtT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.dtT = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dtT.bdv.kv();
    }
}
