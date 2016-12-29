package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends Handler {
    final /* synthetic */ ak dcL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.dcL = akVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean gm;
        if (message.what == 1) {
            this.dcL.dcK = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                gm = this.dcL.gm();
                if (gm) {
                    this.dcL.auR();
                }
            }
            handler = this.dcL.mHandler;
            handler2 = this.dcL.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
