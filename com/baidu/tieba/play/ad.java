package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ ac eWg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(ac acVar, int i) {
        super(i);
        this.eWg = acVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        boolean z2;
        as asVar;
        as asVar2;
        as asVar3;
        as asVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            this.eWg.alL();
            z = this.eWg.dzO;
            if (z) {
                z2 = this.eWg.dzO;
                if (z2) {
                    ac acVar = this.eWg;
                    asVar = this.eWg.dzN;
                    int aXV = asVar.aXV();
                    asVar2 = this.eWg.dzN;
                    int aXW = asVar2.aXW();
                    asVar3 = this.eWg.dzN;
                    boolean aXX = asVar3.aXX();
                    asVar4 = this.eWg.dzN;
                    acVar.a(aXV, aXW, aXX, asVar4.aXY());
                }
            }
        }
    }
}
