package com.baidu.tieba.pb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends Thread {
    private com.baidu.tieba.a.af a;
    private com.baidu.tieba.d.t b = null;

    public bg(com.baidu.tieba.a.af afVar) {
        this.a = null;
        this.a = afVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/post/addstore");
        com.baidu.tieba.c.c cVar = new com.baidu.tieba.c.c();
        cVar.a(this.a);
        this.b.a("data", cVar.a(0, 1));
        this.b.i();
    }
}
