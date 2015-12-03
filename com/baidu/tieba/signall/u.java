package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ s dre;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.dre = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dre.postDelayed(this, 2000L);
    }
}
