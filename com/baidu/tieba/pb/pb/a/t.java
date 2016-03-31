package com.baidu.tieba.pb.pb.a;

import android.os.Handler;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ r dej;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r rVar, int i) {
        super(i);
        this.dej = rVar;
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
        com.baidu.adp.lib.h.h hx = com.baidu.adp.lib.h.h.hx();
        runnable = this.dej.ded;
        hx.removeCallbacks(runnable);
        handler = this.dej.mHandler;
        if (handler != null) {
            handler2 = this.dej.mHandler;
            handler2.removeMessages(1);
        }
        anVar = this.dej.ddX;
        if (anVar != null) {
            anVar2 = this.dej.ddX;
            if (anVar2.deB != null) {
                anVar3 = this.dej.ddX;
                if (anVar3.deC != null) {
                    anVar4 = this.dej.ddX;
                    anVar4.deB.destroy();
                    anVar5 = this.dej.ddX;
                    anVar5.deC.destroy();
                }
            }
        }
    }
}
