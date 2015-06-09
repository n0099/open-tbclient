package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce extends CustomMessageListener {
    final /* synthetic */ cc bTI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ce(cc ccVar, int i) {
        super(i);
        this.bTI = ccVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cf cfVar;
        cf cfVar2;
        cf cfVar3;
        cf cfVar4;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
            com.baidu.tieba.person.a.a data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
            if (data2 != null) {
                cfVar3 = this.bTI.bTu;
                if (cfVar3 != null) {
                    cfVar4 = this.bTI.bTu;
                    cfVar4.d(data2, true);
                    return;
                }
                return;
            }
            cfVar = this.bTI.bTu;
            if (cfVar != null) {
                cfVar2 = this.bTI.bTu;
                cfVar2.A("", true);
            }
        }
    }
}
