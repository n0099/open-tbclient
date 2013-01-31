package com.baidu.tieba.more;
/* loaded from: classes.dex */
class k extends Thread {
    final /* synthetic */ AccountActivity a;
    private String b;

    public k(AccountActivity accountActivity, String str) {
        this.a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.c.t tVar = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/logout");
        tVar.b(false);
        tVar.a("bduss", this.b);
        tVar.i();
    }
}
