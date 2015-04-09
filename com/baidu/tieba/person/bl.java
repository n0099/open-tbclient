package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl extends CustomMessageListener {
    final /* synthetic */ bj bRc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bj bjVar, int i) {
        super(i);
        this.bRc = bjVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
            com.baidu.tieba.person.a.a data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
            if (data2 != null) {
                bmVar3 = this.bRc.bQO;
                if (bmVar3 != null) {
                    bmVar4 = this.bRc.bQO;
                    bmVar4.d(data2, true);
                    return;
                }
                return;
            }
            bmVar = this.bRc.bQO;
            if (bmVar != null) {
                bmVar2 = this.bRc.bQO;
                bmVar2.A("", true);
            }
        }
    }
}
