package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class x extends Handler {
    final /* synthetic */ TiebaUpdateService bJh;

    private x(TiebaUpdateService tiebaUpdateService) {
        this.bJh = tiebaUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(TiebaUpdateService tiebaUpdateService, x xVar) {
        this(tiebaUpdateService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 0) {
            if (message.arg2 > 0) {
                TiebaUpdateService.access$34(this.bJh, message.arg1);
                TiebaUpdateService.access$35(this.bJh, message.arg2);
                if (TiebaUpdateService.access$25(this.bJh) > TiebaUpdateService.access$26(this.bJh)) {
                    TiebaUpdateService.access$16(this.bJh, System.currentTimeMillis());
                }
                TiebaUpdateService.access$27(this.bJh, (int) (((TiebaUpdateService.access$22(this.bJh) + TiebaUpdateService.access$26(this.bJh)) * 100) / (TiebaUpdateService.access$21(this.bJh) + TiebaUpdateService.access$25(this.bJh))));
                if (TiebaUpdateService.access$24(this.bJh)) {
                    if ((TiebaUpdateService.access$12(this.bJh) || TiebaUpdateService.access$13(this.bJh)) && TiebaUpdateService.access$21(this.bJh) == TiebaUpdateService.access$22(this.bJh) && TiebaUpdateService.access$28(this.bJh) > TiebaUpdateService.access$29(this.bJh)) {
                        TiebaUpdateService.access$30(this.bJh, TiebaUpdateService.access$22(this.bJh) + TiebaUpdateService.access$26(this.bJh), TiebaUpdateService.access$21(this.bJh) + TiebaUpdateService.access$25(this.bJh));
                        this.bJh.sendBroadcast(TiebaUpdateService.access$28(this.bJh));
                        TiebaUpdateService.access$31(this.bJh, TiebaUpdateService.access$28(this.bJh));
                    }
                }
            }
        } else if (message.what == 2) {
            if (TiebaUpdateService.access$12(this.bJh) || TiebaUpdateService.access$13(this.bJh)) {
                if (TiebaUpdateService.access$17(this.bJh)) {
                    TiebaUpdateService.access$2(this.bJh).sendMessageDelayed(TiebaUpdateService.access$2(this.bJh).obtainMessage(1, null), 100L);
                    return;
                } else {
                    TiebaUpdateService.access$18(this.bJh, true);
                    return;
                }
            }
            TiebaUpdateService.access$33(this.bJh);
        }
    }
}
