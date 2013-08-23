package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1452a;
    private String b;

    public k(AccountActivity accountActivity, String str) {
        this.f1452a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.v vVar = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/logout");
        vVar.c(false);
        vVar.a(false);
        vVar.a("BDUSS", this.b);
        vVar.a("channel_id", TiebaApplication.g().aY());
        vVar.j();
    }
}
