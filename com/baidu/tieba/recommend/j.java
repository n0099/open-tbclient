package com.baidu.tieba.recommend;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, String str) {
        this.a = iVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        new com.baidu.tieba.c.w(this.b).l();
    }
}
