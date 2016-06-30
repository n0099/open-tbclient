package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ f eDI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f fVar, int i) {
        super(i);
        this.eDI = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            this.eDI.aTy();
            f fVar = this.eDI;
            iVar = this.eDI.eDE;
            int aTz = iVar.aTz();
            iVar2 = this.eDI.eDE;
            int aTA = iVar2.aTA();
            iVar3 = this.eDI.eDE;
            boolean aTB = iVar3.aTB();
            iVar4 = this.eDI.eDE;
            fVar.a(aTz, aTA, aTB, iVar4.getType());
        }
    }
}
