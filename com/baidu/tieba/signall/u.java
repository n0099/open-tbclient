package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ s cRm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.cRm = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cRm.postDelayed(this, 2000L);
    }
}
