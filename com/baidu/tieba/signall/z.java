package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x ekn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.ekn = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ekn.postDelayed(this, 2000L);
    }
}
