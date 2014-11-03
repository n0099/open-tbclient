package com.baidu.tieba.more;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j bqx;
    private final /* synthetic */ String bqy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.bqx = jVar;
        this.bqy = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.util.j.M(this.bqy, 7);
    }
}
