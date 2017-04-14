package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends Handler {
    final /* synthetic */ ah dkP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.dkP = ahVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        if (message.what == 1) {
            this.dkP.dkO = System.currentTimeMillis();
            if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.i.hj()) {
                this.dkP.avm();
            }
            handler = this.dkP.mHandler;
            handler2 = this.dkP.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
