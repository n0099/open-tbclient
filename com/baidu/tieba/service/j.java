package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class j extends Handler {
    final /* synthetic */ TiebaMessageService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TiebaMessageService tiebaMessageService) {
        this.a = tiebaMessageService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        if (message.what != 1) {
            return;
        }
        this.a.a();
        long L = TiebaApplication.b().L();
        if (L > 0) {
            handler = this.a.c;
            handler.sendEmptyMessageDelayed(1, L * 1000);
            return;
        }
        this.a.stopSelf();
    }
}
