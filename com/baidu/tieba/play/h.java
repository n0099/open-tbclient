package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ f ePr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f fVar, int i) {
        super(i);
        this.ePr = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            this.ePr.aWB();
            z = this.ePr.ePn;
            if (z) {
                f fVar = this.ePr;
                iVar = this.ePr.ePm;
                int aWC = iVar.aWC();
                iVar2 = this.ePr.ePm;
                int aWD = iVar2.aWD();
                iVar3 = this.ePr.ePm;
                boolean aWE = iVar3.aWE();
                iVar4 = this.ePr.ePm;
                fVar.a(aWC, aWD, aWE, iVar4.getType());
            }
        }
    }
}
