package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x bQh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.bQh = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bQh.postDelayed(this, 2000L);
    }
}
