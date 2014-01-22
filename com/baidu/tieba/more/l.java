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
        com.baidu.tieba.util.ax axVar = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/s/logout");
        axVar.c(false);
        axVar.a(false);
        axVar.a("BDUSS", this.b);
        axVar.a("channel_id", TiebaApplication.h().bb());
        axVar.a("channel_uid", TiebaApplication.h().ba());
        axVar.m();
    }
}
