package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1495a;
    private String b;

    public k(AccountActivity accountActivity, String str) {
        this.f1495a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.z zVar = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/logout");
        zVar.c(false);
        zVar.a(false);
        zVar.a("BDUSS", this.b);
        zVar.a("channel_id", TiebaApplication.g().aW());
        zVar.j();
    }
}
