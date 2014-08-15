package com.baidu.tieba.more;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.a = jVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.util.k.a(this.b, 7);
    }
}
