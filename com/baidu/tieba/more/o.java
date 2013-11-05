package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f2016a;
    private String b;

    public o(AccountActivity accountActivity, String str) {
        this.f2016a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ag agVar = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/m/register");
        agVar.c(false);
        agVar.a(false);
        agVar.a("BDUSS", this.b);
        agVar.a("channel_id", TiebaApplication.g().bg());
        agVar.a("channel_uid", TiebaApplication.g().bf());
        agVar.j();
    }
}
