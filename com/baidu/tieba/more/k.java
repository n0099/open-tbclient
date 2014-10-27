package com.baidu.tieba.more;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j bqj;
    private final /* synthetic */ String bqk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.bqj = jVar;
        this.bqk = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.util.j.M(this.bqk, 7);
    }
}
