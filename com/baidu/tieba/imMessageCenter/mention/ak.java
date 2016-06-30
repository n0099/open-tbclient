package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends Handler {
    final /* synthetic */ ai def;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.def = aiVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean fr;
        if (message.what == 1) {
            this.def.dee = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                fr = this.def.fr();
                if (fr) {
                    this.def.atE();
                }
            }
            handler = this.def.mHandler;
            handler2 = this.def.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
