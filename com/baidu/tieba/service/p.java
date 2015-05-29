package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class p extends Handler {
    final /* synthetic */ TiebaUpdateService cdF;

    private p(TiebaUpdateService tiebaUpdateService) {
        this.cdF = tiebaUpdateService;
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
                TiebaUpdateService.access$36(this.cdF, message.arg1);
                TiebaUpdateService.access$37(this.cdF, message.arg2);
                if (TiebaUpdateService.access$27(this.cdF) > TiebaUpdateService.access$28(this.cdF)) {
                    TiebaUpdateService.access$18(this.cdF, System.currentTimeMillis());
                }
                TiebaUpdateService.access$29(this.cdF, (int) (((TiebaUpdateService.access$24(this.cdF) + TiebaUpdateService.access$28(this.cdF)) * 100) / (TiebaUpdateService.access$23(this.cdF) + TiebaUpdateService.access$27(this.cdF))));
                if (TiebaUpdateService.access$26(this.cdF)) {
                    if ((TiebaUpdateService.access$13(this.cdF) || TiebaUpdateService.access$14(this.cdF)) && TiebaUpdateService.access$23(this.cdF) == TiebaUpdateService.access$24(this.cdF) && TiebaUpdateService.access$30(this.cdF) > TiebaUpdateService.access$31(this.cdF)) {
                        TiebaUpdateService.access$32(this.cdF, TiebaUpdateService.access$24(this.cdF) + TiebaUpdateService.access$28(this.cdF), TiebaUpdateService.access$23(this.cdF) + TiebaUpdateService.access$27(this.cdF));
                        this.cdF.sendBroadcast(TiebaUpdateService.access$30(this.cdF));
                        TiebaUpdateService.access$33(this.cdF, TiebaUpdateService.access$30(this.cdF));
                    }
                }
            }
        } else if (message.what == 2) {
            if (TiebaUpdateService.access$13(this.cdF) || TiebaUpdateService.access$14(this.cdF)) {
                if (TiebaUpdateService.access$19(this.cdF)) {
                    TiebaUpdateService.access$2(this.cdF).sendMessageDelayed(TiebaUpdateService.access$2(this.cdF).obtainMessage(1, null), 300L);
                    return;
                } else {
                    TiebaUpdateService.access$20(this.cdF, true);
                    return;
                }
            }
            TiebaUpdateService.access$35(this.cdF);
        }
    }
}
