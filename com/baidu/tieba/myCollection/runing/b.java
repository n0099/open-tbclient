package com.baidu.tieba.myCollection.runing;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.location.a3;
import com.baidu.tieba.myCollection.message.RequestQueryCollectUpdateNumMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Handler {
    final /* synthetic */ a bYy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bYy = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        if (message.what == 1) {
            this.bYy.bWF = System.currentTimeMillis();
            MessageManager.getInstance().sendMessage(new RequestQueryCollectUpdateNumMessage());
            handler = this.bYy.mHandler;
            handler2 = this.bYy.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(1), a3.jw);
        }
    }
}
