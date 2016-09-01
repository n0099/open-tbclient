package com.baidu.tieba.play;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ i eWz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, int i) {
        super(i);
        this.eWz = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        boolean z2;
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            this.eWz.aZR();
            z = this.eWz.eWv;
            if (z) {
                z2 = this.eWz.eWv;
                if (z2) {
                    i iVar = this.eWz;
                    lVar = this.eWz.eWu;
                    int aZS = lVar.aZS();
                    lVar2 = this.eWz.eWu;
                    int aZT = lVar2.aZT();
                    lVar3 = this.eWz.eWu;
                    boolean aZU = lVar3.aZU();
                    lVar4 = this.eWz.eWu;
                    iVar.a(aZS, aZT, aZU, lVar4.aZV());
                }
            }
        }
    }
}
