package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class i extends Handler {
    final /* synthetic */ TiebaMessageService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TiebaMessageService tiebaMessageService) {
        this.a = tiebaMessageService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        if (message.what == 1) {
            this.a.a();
            long G = TiebaApplication.a().G();
            if (G <= 0) {
                this.a.stopSelf();
                return;
            }
            handler = this.a.c;
            handler.sendEmptyMessageDelayed(1, G * 1000);
        }
    }
}
