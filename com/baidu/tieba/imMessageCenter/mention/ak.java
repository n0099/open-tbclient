package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends Handler {
    final /* synthetic */ ai duf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.duf = aiVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean gm;
        if (message.what == 1) {
            this.duf.due = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                gm = this.duf.gm();
                if (gm) {
                    this.duf.azC();
                }
            }
            handler = this.duf.mHandler;
            handler2 = this.duf.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
