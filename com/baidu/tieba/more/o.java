package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f2099a;
    private String b;

    public o(AccountActivity accountActivity, String str) {
        this.f2099a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.am amVar = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/m/register");
        amVar.c(false);
        amVar.a(false);
        amVar.a("BDUSS", this.b);
        amVar.a("channel_id", TiebaApplication.h().bc());
        amVar.a("channel_uid", TiebaApplication.h().bb());
        amVar.l();
    }
}
