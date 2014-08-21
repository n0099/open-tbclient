package com.baidu.tieba.signall;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.a = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.postDelayed(this, 2000L);
    }
}
