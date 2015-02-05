package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class s extends Handler {
    final /* synthetic */ TiebaUpdateService bPb;

    private s(TiebaUpdateService tiebaUpdateService) {
        this.bPb = tiebaUpdateService;
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
                TiebaUpdateService.access$35(this.bPb, message.arg1);
                TiebaUpdateService.access$36(this.bPb, message.arg2);
                if (TiebaUpdateService.access$26(this.bPb) > TiebaUpdateService.access$27(this.bPb)) {
                    TiebaUpdateService.access$17(this.bPb, System.currentTimeMillis());
                }
                TiebaUpdateService.access$28(this.bPb, (int) (((TiebaUpdateService.access$23(this.bPb) + TiebaUpdateService.access$27(this.bPb)) * 100) / (TiebaUpdateService.access$22(this.bPb) + TiebaUpdateService.access$26(this.bPb))));
                if (TiebaUpdateService.access$25(this.bPb)) {
                    if ((TiebaUpdateService.access$12(this.bPb) || TiebaUpdateService.access$13(this.bPb)) && TiebaUpdateService.access$22(this.bPb) == TiebaUpdateService.access$23(this.bPb) && TiebaUpdateService.access$29(this.bPb) > TiebaUpdateService.access$30(this.bPb)) {
                        TiebaUpdateService.access$31(this.bPb, TiebaUpdateService.access$23(this.bPb) + TiebaUpdateService.access$27(this.bPb), TiebaUpdateService.access$22(this.bPb) + TiebaUpdateService.access$26(this.bPb));
                        this.bPb.sendBroadcast(TiebaUpdateService.access$29(this.bPb));
                        TiebaUpdateService.access$32(this.bPb, TiebaUpdateService.access$29(this.bPb));
                    }
                }
            }
        } else if (message.what == 2) {
            if (TiebaUpdateService.access$12(this.bPb) || TiebaUpdateService.access$13(this.bPb)) {
                if (TiebaUpdateService.access$18(this.bPb)) {
                    TiebaUpdateService.access$2(this.bPb).sendMessageDelayed(TiebaUpdateService.access$2(this.bPb).obtainMessage(1, null), 100L);
                    return;
                } else {
                    TiebaUpdateService.access$19(this.bPb, true);
                    return;
                }
            }
            TiebaUpdateService.access$34(this.bPb);
        }
    }
}
