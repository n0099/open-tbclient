package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class l extends Handler {
    long a = TbadkApplication.m252getInst().getMsgFrequency();
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
        if (message.what == 1) {
            if (this.a > 0) {
                this.b = 1800 / this.a;
                i = this.c.d;
                if (i % this.b == 0) {
                    this.c.a(2);
                } else {
                    this.c.a(1);
                }
                TiebaMessageService tiebaMessageService = this.c;
                i2 = tiebaMessageService.d;
                tiebaMessageService.d = i2 + 1;
                handler = this.c.f;
                handler.sendEmptyMessageDelayed(1, this.a * 1000);
                return;
            }
            this.c.stopSelf();
        } else if (message.what == 3) {
            if (this.a <= 0) {
                this.c.stopSelf();
            } else {
                this.c.a(3);
            }
        }
    }
}
