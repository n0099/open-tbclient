package com.baidu.tieba.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends Handler {
    final /* synthetic */ v cau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.cau = vVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean iM;
        if (message.what == 1) {
            this.cau.cat = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                iM = this.cau.iM();
                if (iM) {
                    this.cau.ada();
                }
            }
            handler = this.cau.mHandler;
            handler2 = this.cau.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
