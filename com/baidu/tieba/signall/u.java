package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ s cBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.cBu = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cBu.postDelayed(this, 2000L);
    }
}
