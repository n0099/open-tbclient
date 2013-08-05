package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1417a;
    private String b;

    public k(AccountActivity accountActivity, String str) {
        this.f1417a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.u uVar = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/logout");
        uVar.c(false);
        uVar.a(false);
        uVar.a("BDUSS", this.b);
        uVar.a("channel_id", TiebaApplication.f().bj());
        uVar.k();
    }
}
