package com.baidu.tieba.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends Handler {
    final /* synthetic */ v cbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.cbg = vVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean iN;
        if (message.what == 1) {
            this.cbg.cbf = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                iN = this.cbg.iN();
                if (iN) {
                    this.cbg.adr();
                }
            }
            handler = this.cbg.mHandler;
            handler2 = this.cbg.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
