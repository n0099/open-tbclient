package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccountActivity f1991a;
    private String b;

    public o(AccountActivity accountActivity, String str) {
        this.f1991a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ap apVar = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/m/register");
        apVar.c(false);
        apVar.a(false);
        apVar.a("BDUSS", this.b);
        apVar.a("channel_id", TiebaApplication.g().bb());
        apVar.a("channel_uid", TiebaApplication.g().ba());
        apVar.j();
    }
}
