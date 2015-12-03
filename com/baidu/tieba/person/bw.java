package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.person.bu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw extends CustomMessageListener {
    final /* synthetic */ bu cLQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(bu buVar, int i) {
        super(i);
        this.cLQ = buVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bu.a aVar;
        bu.a aVar2;
        bu.a aVar3;
        bu.a aVar4;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
            com.baidu.tieba.person.data.n data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
            if (data2 != null) {
                aVar3 = this.cLQ.cLC;
                if (aVar3 != null) {
                    aVar4 = this.cLQ.cLC;
                    aVar4.d(data2, true);
                    return;
                }
                return;
            }
            aVar = this.cLQ.cLC;
            if (aVar != null) {
                aVar2 = this.cLQ.cLC;
                aVar2.G("", true);
            }
        }
    }
}
