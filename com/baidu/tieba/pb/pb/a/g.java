package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ e dYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.dYX = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Runnable runnable;
        Handler handler;
        Handler handler2;
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        runnable = this.dYX.dYV;
        dL.removeCallbacks(runnable);
        handler = this.dYX.mHandler;
        if (handler != null) {
            handler2 = this.dYX.mHandler;
            handler2.removeMessages(1);
        }
    }
}
