package com.baidu.tieba.tbean;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ BuyTBeanActivity bNs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BuyTBeanActivity buyTBeanActivity) {
        this.bNs = buyTBeanActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVar;
        jVar = this.bNs.bNq;
        jVar.adV();
    }
}
