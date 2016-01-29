package com.baidu.tieba.imMessageCenter.mention;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends Handler {
    final /* synthetic */ ag cni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.cni = agVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        boolean iZ;
        if (message.what == 1) {
            this.cni.cnh = System.currentTimeMillis();
            if (!MessageManager.getInstance().getSocketClient().isValid()) {
                iZ = this.cni.iZ();
                if (iZ) {
                    this.cni.ahP();
                }
            }
            handler = this.cni.mHandler;
            handler2 = this.cni.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 600000L);
        }
    }
}
