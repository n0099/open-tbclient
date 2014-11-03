package com.baidu.tieba.service;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ g bJa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bJa = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean fh;
        if (message.what == 1) {
            this.bJa.bIK = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                fh = this.bJa.fh();
                if (fh) {
                    this.bJa.abU();
                }
            }
            handler = this.bJa.mHandler;
            handler2 = this.bJa.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
