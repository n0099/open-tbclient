package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class k extends Handler {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.a.e = true;
        z = this.a.d;
        if (z) {
            if (!this.a.getDatabasePath("baidu_tieba.db").exists()) {
                TiebaApplication.a(com.baidu.tieba.c.k.l());
            }
            this.a.j();
        }
        super.handleMessage(message);
    }
}
