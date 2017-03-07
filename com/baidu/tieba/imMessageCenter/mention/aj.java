package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends Handler {
    final /* synthetic */ ah dmq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.dmq = ahVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        if (message.what == 1) {
            this.dmq.dmp = System.currentTimeMillis();
            if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.i.he()) {
                this.dmq.avt();
            }
            handler = this.dmq.mHandler;
            handler2 = this.dmq.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
