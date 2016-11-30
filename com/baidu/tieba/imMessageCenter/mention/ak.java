package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends Handler {
    final /* synthetic */ ai dzK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.dzK = aiVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean gm;
        if (message.what == 1) {
            this.dzK.dzJ = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                gm = this.dzK.gm();
                if (gm) {
                    this.dzK.aBy();
                }
            }
            handler = this.dzK.mHandler;
            handler2 = this.dzK.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
