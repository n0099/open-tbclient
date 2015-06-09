package com.baidu.tieba.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends Handler {
    final /* synthetic */ r bGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.bGj = rVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean iX;
        if (message.what == 1) {
            this.bGj.bGi = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                iX = this.bGj.iX();
                if (iX) {
                    this.bGj.Zn();
                }
            }
            handler = this.bGj.mHandler;
            handler2 = this.bGj.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
