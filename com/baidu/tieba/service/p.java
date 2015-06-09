package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class p extends Handler {
    final /* synthetic */ TiebaUpdateService cdG;

    private p(TiebaUpdateService tiebaUpdateService) {
        this.cdG = tiebaUpdateService;
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
                TiebaUpdateService.access$36(this.cdG, message.arg1);
                TiebaUpdateService.access$37(this.cdG, message.arg2);
                if (TiebaUpdateService.access$27(this.cdG) > TiebaUpdateService.access$28(this.cdG)) {
                    TiebaUpdateService.access$18(this.cdG, System.currentTimeMillis());
                }
                TiebaUpdateService.access$29(this.cdG, (int) (((TiebaUpdateService.access$24(this.cdG) + TiebaUpdateService.access$28(this.cdG)) * 100) / (TiebaUpdateService.access$23(this.cdG) + TiebaUpdateService.access$27(this.cdG))));
                if (TiebaUpdateService.access$26(this.cdG)) {
                    if ((TiebaUpdateService.access$13(this.cdG) || TiebaUpdateService.access$14(this.cdG)) && TiebaUpdateService.access$23(this.cdG) == TiebaUpdateService.access$24(this.cdG) && TiebaUpdateService.access$30(this.cdG) > TiebaUpdateService.access$31(this.cdG)) {
                        TiebaUpdateService.access$32(this.cdG, TiebaUpdateService.access$24(this.cdG) + TiebaUpdateService.access$28(this.cdG), TiebaUpdateService.access$23(this.cdG) + TiebaUpdateService.access$27(this.cdG));
                        this.cdG.sendBroadcast(TiebaUpdateService.access$30(this.cdG));
                        TiebaUpdateService.access$33(this.cdG, TiebaUpdateService.access$30(this.cdG));
                    }
                }
            }
        } else if (message.what == 2) {
            if (TiebaUpdateService.access$13(this.cdG) || TiebaUpdateService.access$14(this.cdG)) {
                if (TiebaUpdateService.access$19(this.cdG)) {
                    TiebaUpdateService.access$2(this.cdG).sendMessageDelayed(TiebaUpdateService.access$2(this.cdG).obtainMessage(1, null), 300L);
                    return;
                } else {
                    TiebaUpdateService.access$20(this.cdG, true);
                    return;
                }
            }
            TiebaUpdateService.access$35(this.cdG);
        }
    }
}
