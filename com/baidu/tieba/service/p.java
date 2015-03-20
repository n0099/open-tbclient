package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class p extends Handler {
    final /* synthetic */ TiebaUpdateService bZe;

    private p(TiebaUpdateService tiebaUpdateService) {
        this.bZe = tiebaUpdateService;
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
                TiebaUpdateService.access$35(this.bZe, message.arg1);
                TiebaUpdateService.access$36(this.bZe, message.arg2);
                if (TiebaUpdateService.access$26(this.bZe) > TiebaUpdateService.access$27(this.bZe)) {
                    TiebaUpdateService.access$17(this.bZe, System.currentTimeMillis());
                }
                TiebaUpdateService.access$28(this.bZe, (int) (((TiebaUpdateService.access$23(this.bZe) + TiebaUpdateService.access$27(this.bZe)) * 100) / (TiebaUpdateService.access$22(this.bZe) + TiebaUpdateService.access$26(this.bZe))));
                if (TiebaUpdateService.access$25(this.bZe)) {
                    if ((TiebaUpdateService.access$12(this.bZe) || TiebaUpdateService.access$13(this.bZe)) && TiebaUpdateService.access$22(this.bZe) == TiebaUpdateService.access$23(this.bZe) && TiebaUpdateService.access$29(this.bZe) > TiebaUpdateService.access$30(this.bZe)) {
                        TiebaUpdateService.access$31(this.bZe, TiebaUpdateService.access$23(this.bZe) + TiebaUpdateService.access$27(this.bZe), TiebaUpdateService.access$22(this.bZe) + TiebaUpdateService.access$26(this.bZe));
                        this.bZe.sendBroadcast(TiebaUpdateService.access$29(this.bZe));
                        TiebaUpdateService.access$32(this.bZe, TiebaUpdateService.access$29(this.bZe));
                    }
                }
            }
        } else if (message.what == 2) {
            if (TiebaUpdateService.access$12(this.bZe) || TiebaUpdateService.access$13(this.bZe)) {
                if (TiebaUpdateService.access$18(this.bZe)) {
                    TiebaUpdateService.access$2(this.bZe).sendMessageDelayed(TiebaUpdateService.access$2(this.bZe).obtainMessage(1, null), 100L);
                    return;
                } else {
                    TiebaUpdateService.access$19(this.bZe, true);
                    return;
                }
            }
            TiebaUpdateService.access$34(this.bZe);
        }
    }
}
