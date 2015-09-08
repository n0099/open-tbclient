package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ s cJS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.cJS = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cJS.postDelayed(this, 2000L);
    }
}
