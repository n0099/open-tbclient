package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    final /* synthetic */ q cKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(q qVar, int i) {
        super(i);
        this.cKS = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Runnable runnable;
        Handler handler;
        am amVar;
        am amVar2;
        am amVar3;
        am amVar4;
        am amVar5;
        Handler handler2;
        com.baidu.adp.lib.h.h hr = com.baidu.adp.lib.h.h.hr();
        runnable = this.cKS.cKM;
        hr.removeCallbacks(runnable);
        handler = this.cKS.mHandler;
        if (handler != null) {
            handler2 = this.cKS.mHandler;
            handler2.removeMessages(1);
        }
        amVar = this.cKS.cKF;
        if (amVar != null) {
            amVar2 = this.cKS.cKF;
            if (amVar2.cLl != null) {
                amVar3 = this.cKS.cKF;
                if (amVar3.cLm != null) {
                    amVar4 = this.cKS.cKF;
                    amVar4.cLl.destroy();
                    amVar5 = this.cKS.cKF;
                    amVar5.cLm.destroy();
                }
            }
        }
    }
}
