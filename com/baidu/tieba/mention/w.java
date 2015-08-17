package com.baidu.tieba.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends Handler {
    final /* synthetic */ u bWa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.bWa = uVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean iO;
        if (message.what == 1) {
            this.bWa.bVZ = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                iO = this.bWa.iO();
                if (iO) {
                    this.bWa.abD();
                }
            }
            handler = this.bWa.mHandler;
            handler2 = this.bWa.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
