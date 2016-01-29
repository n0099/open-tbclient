package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends CustomMessageListener {
    final /* synthetic */ q cKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(q qVar, int i) {
        super(i);
        this.cKS = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        am amVar;
        am amVar2;
        am amVar3;
        am amVar4;
        am amVar5;
        am amVar6;
        am amVar7;
        am amVar8;
        amVar = this.cKS.cKF;
        if (amVar != null) {
            amVar2 = this.cKS.cKF;
            if (amVar2.cLd != null) {
                amVar3 = this.cKS.cKF;
                if (amVar3.cLn != null) {
                    amVar4 = this.cKS.cKF;
                    if (amVar4.cLk != null) {
                        amVar5 = this.cKS.cKF;
                        amVar5.cLd.setVisibility(0);
                        amVar6 = this.cKS.cKF;
                        amVar6.cLn.setVisibility(8);
                        amVar7 = this.cKS.cKF;
                        amVar7.cLk.stopPlayback();
                        this.cKS.cKH = true;
                        q qVar = this.cKS;
                        amVar8 = this.cKS.cKF;
                        qVar.c(amVar8);
                    }
                }
            }
        }
    }
}
