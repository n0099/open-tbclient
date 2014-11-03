package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw extends CustomMessageListener {
    final /* synthetic */ bu bDu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(bu buVar, int i) {
        super(i);
        this.bDu = buVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bx bxVar;
        bx bxVar2;
        bx bxVar3;
        bx bxVar4;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
            com.baidu.tieba.data.aj data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
            if (data2 != null) {
                bxVar3 = this.bDu.bDg;
                if (bxVar3 != null) {
                    bxVar4 = this.bDu.bDg;
                    bxVar4.d(data2, true);
                    return;
                }
                return;
            }
            bxVar = this.bDu.bDg;
            if (bxVar != null) {
                bxVar2 = this.bDu.bDg;
                bxVar2.D("", true);
            }
        }
    }
}
