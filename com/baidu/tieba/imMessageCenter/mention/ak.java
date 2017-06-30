package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ak extends Handler {
    final /* synthetic */ ai duD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.duD = aiVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        if (message.what == 1) {
            this.duD.duC = System.currentTimeMillis();
            if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.i.hj()) {
                this.duD.axL();
            }
            handler = this.duD.mHandler;
            handler2 = this.duD.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
