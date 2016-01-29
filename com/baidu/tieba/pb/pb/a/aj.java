package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends CustomMessageListener {
    final /* synthetic */ q cKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(q qVar, int i) {
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
        amVar = this.cKS.cKF;
        if (amVar != null) {
            amVar2 = this.cKS.cKF;
            if (amVar2.cLk != null) {
                int[] iArr = new int[2];
                amVar3 = this.cKS.cKF;
                amVar3.cLk.getLocationInWindow(iArr);
                int i = iArr[1];
                amVar4 = this.cKS.cKF;
                if (i + amVar4.cLk.getHeight() < 0) {
                    this.cKS.apd();
                }
            }
        }
    }
}
