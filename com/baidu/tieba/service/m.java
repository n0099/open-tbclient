package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class m extends Handler {
    long a = TiebaApplication.h().N();
    long b = 0;
    final /* synthetic */ TiebaMessageService c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TiebaMessageService tiebaMessageService) {
        this.c = tiebaMessageService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        Handler handler;
        Handler handler2;
        if (message.what == 1) {
            if (this.a > 0) {
                this.b = 1800 / this.a;
                i = this.c.d;
                if (i % this.b == 0) {
                    this.c.a(2);
                } else {
                    this.c.a(1);
                }
                TiebaMessageService.b(this.c);
                if (TiebaApplication.av()) {
                    handler2 = this.c.f;
                    handler2.sendEmptyMessageDelayed(1, this.a * 1000);
                    return;
                }
                handler = this.c.f;
                handler.removeMessages(1);
                this.c.stopSelf();
                return;
            }
            this.c.stopSelf();
        } else if (message.what == 3) {
            if (this.a > 0) {
                this.c.a(3);
            } else {
                this.c.stopSelf();
            }
        }
    }
}
