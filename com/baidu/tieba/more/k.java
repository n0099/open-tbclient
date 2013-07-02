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
        com.baidu.tieba.util.r rVar = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/s/logout");
        rVar.b(false);
        rVar.a("bduss", this.b);
        rVar.j();
    }
}
