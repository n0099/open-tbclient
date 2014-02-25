package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ba;
/* loaded from: classes.dex */
class o extends Thread {
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
        ba baVar = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/m/register");
        baVar.c(false);
        baVar.a(false);
        baVar.a("BDUSS", this.b);
        baVar.a("channel_id", TiebaApplication.g().aY());
        baVar.a("channel_uid", TiebaApplication.g().aX());
        baVar.m();
    }
}
