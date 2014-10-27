package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class x extends Handler {
    final /* synthetic */ TiebaUpdateService bIT;

    private x(TiebaUpdateService tiebaUpdateService) {
        this.bIT = tiebaUpdateService;
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
                TiebaUpdateService.access$34(this.bIT, message.arg1);
                TiebaUpdateService.access$35(this.bIT, message.arg2);
                if (TiebaUpdateService.access$25(this.bIT) > TiebaUpdateService.access$26(this.bIT)) {
                    TiebaUpdateService.access$16(this.bIT, System.currentTimeMillis());
                }
                TiebaUpdateService.access$27(this.bIT, (int) (((TiebaUpdateService.access$22(this.bIT) + TiebaUpdateService.access$26(this.bIT)) * 100) / (TiebaUpdateService.access$21(this.bIT) + TiebaUpdateService.access$25(this.bIT))));
                if (TiebaUpdateService.access$24(this.bIT)) {
                    if ((TiebaUpdateService.access$12(this.bIT) || TiebaUpdateService.access$13(this.bIT)) && TiebaUpdateService.access$21(this.bIT) == TiebaUpdateService.access$22(this.bIT) && TiebaUpdateService.access$28(this.bIT) > TiebaUpdateService.access$29(this.bIT)) {
                        TiebaUpdateService.access$30(this.bIT, TiebaUpdateService.access$22(this.bIT) + TiebaUpdateService.access$26(this.bIT), TiebaUpdateService.access$21(this.bIT) + TiebaUpdateService.access$25(this.bIT));
                        this.bIT.sendBroadcast(TiebaUpdateService.access$28(this.bIT));
                        TiebaUpdateService.access$31(this.bIT, TiebaUpdateService.access$28(this.bIT));
                    }
                }
            }
        } else if (message.what == 2) {
            if (TiebaUpdateService.access$12(this.bIT) || TiebaUpdateService.access$13(this.bIT)) {
                if (TiebaUpdateService.access$17(this.bIT)) {
                    TiebaUpdateService.access$2(this.bIT).sendMessageDelayed(TiebaUpdateService.access$2(this.bIT).obtainMessage(1, null), 100L);
                    return;
                } else {
                    TiebaUpdateService.access$18(this.bIT, true);
                    return;
                }
            }
            TiebaUpdateService.access$33(this.bIT);
        }
    }
}
