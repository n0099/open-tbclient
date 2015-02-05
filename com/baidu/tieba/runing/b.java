package com.baidu.tieba.runing;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.message.RequestQueryCollectUpdateNumMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a bNF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bNF = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        if (message.what == 1) {
            this.bNF.bNE = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
            handler = this.bNF.mHandler;
            handler2 = this.bNF.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), 1800000L);
        }
    }
}
