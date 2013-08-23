package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class n extends Handler {

    /* renamed from: a  reason: collision with root package name */
    long f1723a = TiebaApplication.g().S();
    long b = 0;
    final /* synthetic */ TiebaMessageService c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TiebaMessageService tiebaMessageService) {
        this.c = tiebaMessageService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        int i2;
        Handler handler;
        if (message.what == 1) {
            if (this.f1723a > 0) {
                this.b = 1800 / this.f1723a;
                i = this.c.d;
                if (i % this.b == 0) {
                    this.c.a(2);
                } else {
                    this.c.a(1);
                }
                TiebaMessageService tiebaMessageService = this.c;
                i2 = tiebaMessageService.d;
                tiebaMessageService.d = i2 + 1;
                handler = this.c.e;
                handler.sendEmptyMessageDelayed(1, this.f1723a * 1000);
                return;
            }
            this.c.stopSelf();
        }
    }
}
