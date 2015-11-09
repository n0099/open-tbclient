package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ s cSH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.cSH = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cSH.postDelayed(this, 2000L);
    }
}
