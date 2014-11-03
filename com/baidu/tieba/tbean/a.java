package com.baidu.tieba.tbean;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ BuyTBeanActivity bNH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BuyTBeanActivity buyTBeanActivity) {
        this.bNH = buyTBeanActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVar;
        jVar = this.bNH.bNF;
        jVar.adY();
    }
}
