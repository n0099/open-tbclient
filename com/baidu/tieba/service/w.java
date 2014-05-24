package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class w extends Handler {
    final /* synthetic */ TiebaUpdateService a;

    private w(TiebaUpdateService tiebaUpdateService) {
        this.a = tiebaUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(TiebaUpdateService tiebaUpdateService, w wVar) {
        this(tiebaUpdateService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 0) {
            if (TiebaUpdateService.access$19(this.a) != null && message.arg2 > 0) {
                TiebaUpdateService.access$35(this.a, message.arg1);
                TiebaUpdateService.access$36(this.a, message.arg2);
                if (TiebaUpdateService.access$26(this.a) > TiebaUpdateService.access$27(this.a)) {
                    TiebaUpdateService.access$16(this.a, System.currentTimeMillis());
                }
                int access$27 = (int) ((TiebaUpdateService.access$27(this.a) * 100) / TiebaUpdateService.access$26(this.a));
                if (TiebaUpdateService.access$25(this.a)) {
                    if ((TiebaUpdateService.access$12(this.a) || TiebaUpdateService.access$13(this.a)) && TiebaUpdateService.access$22(this.a) == TiebaUpdateService.access$23(this.a)) {
                        TiebaUpdateService.access$31(this.a, TiebaUpdateService.access$23(this.a) + TiebaUpdateService.access$27(this.a), TiebaUpdateService.access$22(this.a) + TiebaUpdateService.access$26(this.a));
                        this.a.sendBroadcast(access$27);
                    }
                }
            }
        } else if (message.what == 2) {
            if (TiebaUpdateService.access$12(this.a) || TiebaUpdateService.access$13(this.a)) {
                if (TiebaUpdateService.access$17(this.a)) {
                    TiebaUpdateService.access$2(this.a).sendMessageDelayed(TiebaUpdateService.access$2(this.a).obtainMessage(1, null), 100L);
                    return;
                } else {
                    TiebaUpdateService.access$18(this.a, true);
                    return;
                }
            }
            TiebaUpdateService.access$34(this.a);
        }
    }
}
