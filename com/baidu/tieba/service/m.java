package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class m extends Handler {
    final /* synthetic */ TiebaMessageService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TiebaMessageService tiebaMessageService) {
        this.a = tiebaMessageService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        if (message.what != 1) {
            return;
        }
        this.a.a();
        long N = TiebaApplication.d().N();
        if (N > 0) {
            handler = this.a.c;
            handler.sendEmptyMessageDelayed(1, N * 1000);
            return;
        }
        this.a.stopSelf();
    }
}
