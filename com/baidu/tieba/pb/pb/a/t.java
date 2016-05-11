package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ r dgC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r rVar, int i) {
        super(i);
        this.dgC = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Runnable runnable;
        Handler handler;
        an anVar;
        an anVar2;
        an anVar3;
        an anVar4;
        an anVar5;
        Handler handler2;
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        runnable = this.dgC.dgw;
        dL.removeCallbacks(runnable);
        handler = this.dgC.mHandler;
        if (handler != null) {
            handler2 = this.dgC.mHandler;
            handler2.removeMessages(1);
        }
        anVar = this.dgC.dgr;
        if (anVar != null) {
            anVar2 = this.dgC.dgr;
            if (anVar2.dgU != null) {
                anVar3 = this.dgC.dgr;
                if (anVar3.dgV != null) {
                    anVar4 = this.dgC.dgr;
                    anVar4.dgU.destroy();
                    anVar5 = this.dgC.dgr;
                    anVar5.dgV.destroy();
                }
            }
        }
    }
}
