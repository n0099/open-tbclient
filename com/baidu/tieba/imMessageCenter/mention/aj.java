package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends Handler {
    final /* synthetic */ ah djW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.djW = ahVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        if (message.what == 1) {
            this.djW.djV = System.currentTimeMillis();
            if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.i.gk()) {
                this.djW.avX();
            }
            handler = this.djW.mHandler;
            handler2 = this.djW.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
