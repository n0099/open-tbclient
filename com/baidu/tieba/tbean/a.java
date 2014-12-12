package com.baidu.tieba.tbean;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ BuyTBeanActivity bZR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BuyTBeanActivity buyTBeanActivity) {
        this.bZR = buyTBeanActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVar;
        jVar = this.bZR.bZP;
        jVar.ais();
    }
}
