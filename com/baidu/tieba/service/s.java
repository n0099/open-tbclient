package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class s extends Handler {
    final /* synthetic */ TiebaUpdateService bPc;

    private s(TiebaUpdateService tiebaUpdateService) {
        this.bPc = tiebaUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(TiebaUpdateService tiebaUpdateService, s sVar) {
        this(tiebaUpdateService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 0) {
            if (message.arg2 > 0) {
                TiebaUpdateService.access$35(this.bPc, message.arg1);
                TiebaUpdateService.access$36(this.bPc, message.arg2);
                if (TiebaUpdateService.access$26(this.bPc) > TiebaUpdateService.access$27(this.bPc)) {
                    TiebaUpdateService.access$17(this.bPc, System.currentTimeMillis());
                }
                TiebaUpdateService.access$28(this.bPc, (int) (((TiebaUpdateService.access$23(this.bPc) + TiebaUpdateService.access$27(this.bPc)) * 100) / (TiebaUpdateService.access$22(this.bPc) + TiebaUpdateService.access$26(this.bPc))));
                if (TiebaUpdateService.access$25(this.bPc)) {
                    if ((TiebaUpdateService.access$12(this.bPc) || TiebaUpdateService.access$13(this.bPc)) && TiebaUpdateService.access$22(this.bPc) == TiebaUpdateService.access$23(this.bPc) && TiebaUpdateService.access$29(this.bPc) > TiebaUpdateService.access$30(this.bPc)) {
                        TiebaUpdateService.access$31(this.bPc, TiebaUpdateService.access$23(this.bPc) + TiebaUpdateService.access$27(this.bPc), TiebaUpdateService.access$22(this.bPc) + TiebaUpdateService.access$26(this.bPc));
                        this.bPc.sendBroadcast(TiebaUpdateService.access$29(this.bPc));
                        TiebaUpdateService.access$32(this.bPc, TiebaUpdateService.access$29(this.bPc));
                    }
                }
            }
        } else if (message.what == 2) {
            if (TiebaUpdateService.access$12(this.bPc) || TiebaUpdateService.access$13(this.bPc)) {
                if (TiebaUpdateService.access$18(this.bPc)) {
                    TiebaUpdateService.access$2(this.bPc).sendMessageDelayed(TiebaUpdateService.access$2(this.bPc).obtainMessage(1, null), 100L);
                    return;
                } else {
                    TiebaUpdateService.access$19(this.bPc, true);
                    return;
                }
            }
            TiebaUpdateService.access$34(this.bPc);
        }
    }
}
