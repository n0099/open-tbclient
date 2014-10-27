package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends CustomMessageListener {
    final /* synthetic */ bt bDg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(bt btVar, int i) {
        super(i);
        this.bDg = btVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bw bwVar;
        bw bwVar2;
        bw bwVar3;
        bw bwVar4;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
            com.baidu.tieba.data.aj data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
            if (data2 != null) {
                bwVar3 = this.bDg.bCS;
                if (bwVar3 != null) {
                    bwVar4 = this.bDg.bCS;
                    bwVar4.d(data2, true);
                    return;
                }
                return;
            }
            bwVar = this.bDg.bCS;
            if (bwVar != null) {
                bwVar2 = this.bDg.bCS;
                bwVar2.D("", true);
            }
        }
    }
}
