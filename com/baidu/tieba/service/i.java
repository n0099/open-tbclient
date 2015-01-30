package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ g bOX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bOX = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean ff;
        if (message.what == 1) {
            this.bOX.bNF = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                ff = this.bOX.ff();
                if (ff) {
                    this.bOX.acT();
                }
            }
            handler = this.bOX.mHandler;
            handler2 = this.bOX.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
