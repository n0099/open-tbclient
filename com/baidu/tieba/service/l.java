package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class l extends Handler {

    /* renamed from: a  reason: collision with root package name */
    long f1795a = TiebaApplication.g().Q();
    long b = 0;
    final /* synthetic */ TiebaMessageService c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TiebaMessageService tiebaMessageService) {
        this.c = tiebaMessageService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        int i2;
        Handler handler;
        Handler handler2;
        if (message.what == 1) {
            if (this.f1795a > 0) {
                this.b = 1800 / this.f1795a;
                i = this.c.d;
                if (i % this.b == 0) {
                    this.c.a(2);
                } else {
                    this.c.a(1);
                }
                TiebaMessageService tiebaMessageService = this.c;
                i2 = tiebaMessageService.d;
                tiebaMessageService.d = i2 + 1;
                if (TiebaApplication.av()) {
                    handler2 = this.c.e;
                    handler2.sendEmptyMessageDelayed(1, this.f1795a * 1000);
                    return;
                }
                handler = this.c.e;
                handler.removeMessages(1);
                this.c.stopSelf();
                return;
            }
            this.c.stopSelf();
        } else if (message.what == 3) {
            if (this.f1795a <= 0) {
                this.c.stopSelf();
            } else {
                this.c.a(3);
            }
        }
    }
}
