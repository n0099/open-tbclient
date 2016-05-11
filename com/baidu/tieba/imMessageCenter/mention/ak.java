package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends Handler {
    final /* synthetic */ ai cyJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.cyJ = aiVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean fq;
        if (message.what == 1) {
            this.cyJ.cyI = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                fq = this.cyJ.fq();
                if (fq) {
                    this.cyJ.alp();
                }
            }
            handler = this.cyJ.mHandler;
            handler2 = this.cyJ.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
