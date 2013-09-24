package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class n extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1498a;
    private String b;

    public n(AccountActivity accountActivity, String str) {
        this.f1498a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.z zVar = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/m/register");
        zVar.c(false);
        zVar.a(false);
        zVar.a("BDUSS", this.b);
        zVar.a("channel_id", TiebaApplication.g().aW());
        zVar.j();
    }
}
