package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {
    final /* synthetic */ AccountActivity a;
    private String b;

    public o(AccountActivity accountActivity, String str) {
        this.a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.an anVar = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/m/register");
        anVar.c(false);
        anVar.a(false);
        anVar.a("BDUSS", this.b);
        anVar.a("channel_id", TiebaApplication.h().bc());
        anVar.a("channel_uid", TiebaApplication.h().bb());
        anVar.l();
    }
}
