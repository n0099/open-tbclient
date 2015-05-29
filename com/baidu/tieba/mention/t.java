package com.baidu.tieba.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends Handler {
    final /* synthetic */ r bGi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.bGi = rVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean iX;
        if (message.what == 1) {
            this.bGi.bGh = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                iX = this.bGi.iX();
                if (iX) {
                    this.bGi.Zm();
                }
            }
            handler = this.bGi.mHandler;
            handler2 = this.bGi.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
