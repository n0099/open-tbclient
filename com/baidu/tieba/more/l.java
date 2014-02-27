package com.baidu.tieba.more;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ba;
/* loaded from: classes.dex */
final class l extends Thread {
    final /* synthetic */ AccountActivity a;
    private String b;

    public l(AccountActivity accountActivity, String str) {
        this.a = accountActivity;
        this.b = null;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        ba baVar = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/logout");
        baVar.c(false);
        baVar.a(false);
        baVar.a("BDUSS", this.b);
        baVar.a("channel_id", TiebaApplication.g().aQ());
        baVar.a("channel_uid", TiebaApplication.g().aP());
        baVar.l();
    }
}
