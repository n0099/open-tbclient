package com.baidu.tieba.more;
/* loaded from: classes.dex */
class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1099a;
    private String b;

    public k(AccountActivity accountActivity, String str) {
        this.f1099a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.r rVar = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/logout");
        rVar.b(false);
        rVar.a("bduss", this.b);
        rVar.j();
    }
}
