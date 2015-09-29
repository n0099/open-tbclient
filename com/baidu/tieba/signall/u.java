package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ s cQN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.cQN = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cQN.postDelayed(this, 2000L);
    }
}
