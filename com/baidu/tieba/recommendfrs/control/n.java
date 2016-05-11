package com.baidu.tieba.recommendfrs.control;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Handler.Callback {
    final /* synthetic */ m dZb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.dZb = mVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.dZb.RQ()) {
            switch (message.what) {
                case 1:
                    this.dZb.RM();
                    return true;
                case 2:
                    this.dZb.RK();
                    return true;
                case 3:
                    this.dZb.RL();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.dZb.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
