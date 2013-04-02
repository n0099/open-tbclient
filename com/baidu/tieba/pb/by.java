package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by extends Thread {
    private com.baidu.tieba.a.ae a;
    private com.baidu.tieba.c.t b = null;

    public by(com.baidu.tieba.a.ae aeVar) {
        this.a = null;
        this.a = aeVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/post/addstore");
        com.baidu.tieba.b.j jVar = new com.baidu.tieba.b.j();
        jVar.a(this.a);
        this.b.a("data", jVar.a(0, 1));
        this.b.i();
    }
}
