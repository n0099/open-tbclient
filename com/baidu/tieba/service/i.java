package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ g bOW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bOW = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean ff;
        if (message.what == 1) {
            this.bOW.bNE = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                ff = this.bOW.ff();
                if (ff) {
                    this.bOW.acO();
                }
            }
            handler = this.bOW.mHandler;
            handler2 = this.bOW.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
