package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class p extends Handler {
    long a = TbadkApplication.m252getInst().getMsgFrequency();
    long b = 0;
    final /* synthetic */ TiebaMessageService c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TiebaMessageService tiebaMessageService) {
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
                i = this.c.mFlag;
                if (i % this.b == 0) {
                    this.c.getMsg(2);
                } else {
                    this.c.getMsg(1);
                }
                TiebaMessageService tiebaMessageService = this.c;
                i2 = tiebaMessageService.mFlag;
                tiebaMessageService.mFlag = i2 + 1;
                handler = this.c.mHandler;
                handler.sendEmptyMessageDelayed(1, this.a * 1000);
                return;
            }
            this.c.stopSelf();
        } else if (message.what == 3) {
            if (this.a <= 0) {
                this.c.stopSelf();
            } else {
                this.c.getMsg(3);
            }
        }
    }
}
