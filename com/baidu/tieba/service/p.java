package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class p extends Handler {
    final /* synthetic */ TiebaUpdateService bZt;

    private p(TiebaUpdateService tiebaUpdateService) {
        this.bZt = tiebaUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(TiebaUpdateService tiebaUpdateService, p pVar) {
        this(tiebaUpdateService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 0) {
            if (message.arg2 > 0) {
                TiebaUpdateService.access$35(this.bZt, message.arg1);
                TiebaUpdateService.access$36(this.bZt, message.arg2);
                if (TiebaUpdateService.access$26(this.bZt) > TiebaUpdateService.access$27(this.bZt)) {
                    TiebaUpdateService.access$17(this.bZt, System.currentTimeMillis());
                }
                TiebaUpdateService.access$28(this.bZt, (int) (((TiebaUpdateService.access$23(this.bZt) + TiebaUpdateService.access$27(this.bZt)) * 100) / (TiebaUpdateService.access$22(this.bZt) + TiebaUpdateService.access$26(this.bZt))));
                if (TiebaUpdateService.access$25(this.bZt)) {
                    if ((TiebaUpdateService.access$12(this.bZt) || TiebaUpdateService.access$13(this.bZt)) && TiebaUpdateService.access$22(this.bZt) == TiebaUpdateService.access$23(this.bZt) && TiebaUpdateService.access$29(this.bZt) > TiebaUpdateService.access$30(this.bZt)) {
                        TiebaUpdateService.access$31(this.bZt, TiebaUpdateService.access$23(this.bZt) + TiebaUpdateService.access$27(this.bZt), TiebaUpdateService.access$22(this.bZt) + TiebaUpdateService.access$26(this.bZt));
                        this.bZt.sendBroadcast(TiebaUpdateService.access$29(this.bZt));
                        TiebaUpdateService.access$32(this.bZt, TiebaUpdateService.access$29(this.bZt));
                    }
                }
            }
        } else if (message.what == 2) {
            if (TiebaUpdateService.access$12(this.bZt) || TiebaUpdateService.access$13(this.bZt)) {
                if (TiebaUpdateService.access$18(this.bZt)) {
                    TiebaUpdateService.access$2(this.bZt).sendMessageDelayed(TiebaUpdateService.access$2(this.bZt).obtainMessage(1, null), 100L);
                    return;
                } else {
                    TiebaUpdateService.access$19(this.bZt, true);
                    return;
                }
            }
            TiebaUpdateService.access$34(this.bZt);
        }
    }
}
