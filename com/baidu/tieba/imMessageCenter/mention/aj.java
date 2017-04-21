package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends Handler {
    final /* synthetic */ ah dng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.dng = ahVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        if (message.what == 1) {
            this.dng.dnf = System.currentTimeMillis();
            if ((!MessageManager.getInstance().getSocketClient().isValid()) && com.baidu.adp.lib.util.i.hk()) {
                this.dng.awn();
            }
            handler = this.dng.mHandler;
            handler2 = this.dng.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
