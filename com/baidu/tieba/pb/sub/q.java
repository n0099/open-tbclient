package com.baidu.tieba.pb.sub;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ l a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar, String str) {
        this.a = lVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(this.b);
    }
}
