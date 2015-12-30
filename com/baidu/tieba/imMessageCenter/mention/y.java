package com.baidu.tieba.imMessageCenter.mention;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ w ciw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.ciw = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ciw.aRc.nb();
    }
}
