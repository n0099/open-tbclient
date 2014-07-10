package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class v extends Handler {
    final /* synthetic */ TiebaUpdateService a;

    private v(TiebaUpdateService tiebaUpdateService) {
        this.a = tiebaUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(TiebaUpdateService tiebaUpdateService, v vVar) {
        this(tiebaUpdateService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 0) {
            if (message.arg2 > 0) {
                TiebaUpdateService.access$34(this.a, message.arg1);
                TiebaUpdateService.access$35(this.a, message.arg2);
                if (TiebaUpdateService.access$25(this.a) > TiebaUpdateService.access$26(this.a)) {
                    TiebaUpdateService.access$16(this.a, System.currentTimeMillis());
                }
                TiebaUpdateService.access$27(this.a, (int) (((TiebaUpdateService.access$22(this.a) + TiebaUpdateService.access$26(this.a)) * 100) / (TiebaUpdateService.access$21(this.a) + TiebaUpdateService.access$25(this.a))));
                if (TiebaUpdateService.access$24(this.a)) {
                    if ((TiebaUpdateService.access$12(this.a) || TiebaUpdateService.access$13(this.a)) && TiebaUpdateService.access$21(this.a) == TiebaUpdateService.access$22(this.a) && TiebaUpdateService.access$28(this.a) > TiebaUpdateService.access$29(this.a)) {
                        TiebaUpdateService.access$30(this.a, TiebaUpdateService.access$22(this.a) + TiebaUpdateService.access$26(this.a), TiebaUpdateService.access$21(this.a) + TiebaUpdateService.access$25(this.a));
                        this.a.sendBroadcast(TiebaUpdateService.access$28(this.a));
                        TiebaUpdateService.access$31(this.a, TiebaUpdateService.access$28(this.a));
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
            TiebaUpdateService.access$33(this.a);
        }
    }
}
