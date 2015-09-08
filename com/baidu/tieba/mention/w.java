package com.baidu.tieba.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends Handler {
    final /* synthetic */ u bWG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.bWG = uVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean iL;
        if (message.what == 1) {
            this.bWG.bWF = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                iL = this.bWG.iL();
                if (iL) {
                    this.bWG.abI();
                }
            }
            handler = this.bWG.mHandler;
            handler2 = this.bWG.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
