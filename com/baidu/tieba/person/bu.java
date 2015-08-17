package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.person.bs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends CustomMessageListener {
    final /* synthetic */ bs ckq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(bs bsVar, int i) {
        super(i);
        this.ckq = bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bs.a aVar;
        bs.a aVar2;
        bs.a aVar3;
        bs.a aVar4;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
            com.baidu.tieba.person.a.a data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
            if (data2 != null) {
                aVar3 = this.ckq.ckc;
                if (aVar3 != null) {
                    aVar4 = this.ckq.ckc;
                    aVar4.d(data2, true);
                    return;
                }
                return;
            }
            aVar = this.ckq.ckc;
            if (aVar != null) {
                aVar2 = this.ckq.ckc;
                aVar2.B("", true);
            }
        }
    }
}
