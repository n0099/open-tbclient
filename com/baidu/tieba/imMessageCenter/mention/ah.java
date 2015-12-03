package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends Handler {
    final /* synthetic */ af ceG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.ceG = afVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean iP;
        if (message.what == 1) {
            this.ceG.ceF = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                iP = this.ceG.iP();
                if (iP) {
                    this.ceG.adx();
                }
            }
            handler = this.ceG.mHandler;
            handler2 = this.ceG.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
