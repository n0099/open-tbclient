package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class j extends Handler {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.a.c = true;
        z = this.a.b;
        if (z) {
            this.a.h();
        }
        super.handleMessage(message);
    }
}
