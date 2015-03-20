package com.baidu.tieba.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends Handler {
    final /* synthetic */ r bDa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.bDa = rVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean iH;
        if (message.what == 1) {
            this.bDa.bCZ = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                iH = this.bDa.iH();
                if (iH) {
                    this.bDa.XB();
                }
            }
            handler = this.bDa.mHandler;
            handler2 = this.bDa.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
