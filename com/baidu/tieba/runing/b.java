package com.baidu.tieba.runing;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.message.RequestQueryCollectUpdateNumMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a bIL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bIL = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        if (message.what == 1) {
            this.bIL.bIK = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
            handler = this.bIL.mHandler;
            handler2 = this.bIL.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 1800000L);
        }
    }
}
