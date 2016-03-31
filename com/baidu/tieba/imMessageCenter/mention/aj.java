package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends Handler {
    final /* synthetic */ ah cxK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar) {
        this.cxK = ahVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean jf;
        if (message.what == 1) {
            this.cxK.cxJ = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                jf = this.cxK.jf();
                if (jf) {
                    this.cxK.alj();
                }
            }
            handler = this.cxK.mHandler;
            handler2 = this.cxK.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
