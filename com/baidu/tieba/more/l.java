package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends Thread {
    final /* synthetic */ AccountActivity a;
    private String b;

    public l(AccountActivity accountActivity, String str) {
        this.a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.at atVar = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/s/logout");
        atVar.c(false);
        atVar.a(false);
        atVar.a("BDUSS", this.b);
        atVar.a("channel_id", TiebaApplication.g().bc());
        atVar.a("channel_uid", TiebaApplication.g().bb());
        atVar.l();
    }
}
