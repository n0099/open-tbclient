package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ g bNn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bNn = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean fg;
        if (message.what == 1) {
            this.bNn.bLV = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                fg = this.bNn.fg();
                if (fg) {
                    this.bNn.acp();
                }
            }
            handler = this.bNn.mHandler;
            handler2 = this.bNn.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
