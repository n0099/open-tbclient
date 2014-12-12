package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class t extends Handler {
    final /* synthetic */ TiebaUpdateService bNs;

    private t(TiebaUpdateService tiebaUpdateService) {
        this.bNs = tiebaUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(TiebaUpdateService tiebaUpdateService, t tVar) {
        this(tiebaUpdateService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 0) {
            if (message.arg2 > 0) {
                TiebaUpdateService.access$35(this.bNs, message.arg1);
                TiebaUpdateService.access$36(this.bNs, message.arg2);
                if (TiebaUpdateService.access$26(this.bNs) > TiebaUpdateService.access$27(this.bNs)) {
                    TiebaUpdateService.access$17(this.bNs, System.currentTimeMillis());
                }
                TiebaUpdateService.access$28(this.bNs, (int) (((TiebaUpdateService.access$23(this.bNs) + TiebaUpdateService.access$27(this.bNs)) * 100) / (TiebaUpdateService.access$22(this.bNs) + TiebaUpdateService.access$26(this.bNs))));
                if (TiebaUpdateService.access$25(this.bNs)) {
                    if ((TiebaUpdateService.access$12(this.bNs) || TiebaUpdateService.access$13(this.bNs)) && TiebaUpdateService.access$22(this.bNs) == TiebaUpdateService.access$23(this.bNs) && TiebaUpdateService.access$29(this.bNs) > TiebaUpdateService.access$30(this.bNs)) {
                        TiebaUpdateService.access$31(this.bNs, TiebaUpdateService.access$23(this.bNs) + TiebaUpdateService.access$27(this.bNs), TiebaUpdateService.access$22(this.bNs) + TiebaUpdateService.access$26(this.bNs));
                        this.bNs.sendBroadcast(TiebaUpdateService.access$29(this.bNs));
                        TiebaUpdateService.access$32(this.bNs, TiebaUpdateService.access$29(this.bNs));
                    }
                }
            }
        } else if (message.what == 2) {
            if (TiebaUpdateService.access$12(this.bNs) || TiebaUpdateService.access$13(this.bNs)) {
                if (TiebaUpdateService.access$18(this.bNs)) {
                    TiebaUpdateService.access$2(this.bNs).sendMessageDelayed(TiebaUpdateService.access$2(this.bNs).obtainMessage(1, null), 100L);
                    return;
                } else {
                    TiebaUpdateService.access$19(this.bNs, true);
                    return;
                }
            }
            TiebaUpdateService.access$34(this.bNs);
        }
    }
}
