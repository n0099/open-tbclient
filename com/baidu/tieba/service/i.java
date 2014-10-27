package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ g bIM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bIM = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean fh;
        if (message.what == 1) {
            this.bIM.bIw = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                fh = this.bIM.fh();
                if (fh) {
                    this.bIM.abR();
                }
            }
            handler = this.bIM.mHandler;
            handler2 = this.bIM.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
