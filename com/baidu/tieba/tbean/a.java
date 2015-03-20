package com.baidu.tieba.tbean;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ BuyTBeanActivity cqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BuyTBeanActivity buyTBeanActivity) {
        this.cqi = buyTBeanActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVar;
        jVar = this.cqi.cqg;
        jVar.anQ();
    }
}
