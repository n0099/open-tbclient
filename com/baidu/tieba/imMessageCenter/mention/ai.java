package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends Handler {
    final /* synthetic */ ag ciI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.ciI = agVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean iQ;
        if (message.what == 1) {
            this.ciI.ciH = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                iQ = this.ciI.iQ();
                if (iQ) {
                    this.ciI.aeF();
                }
            }
            handler = this.ciI.mHandler;
            handler2 = this.ciI.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
