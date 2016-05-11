package com.baidu.tieba.recommendfrs.control;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class r extends CustomMessageListener {
    final /* synthetic */ q dZi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(q qVar, int i) {
        super(i);
        this.dZi = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            this.dZi.iO(((Boolean) customResponsedMessage.getData()).booleanValue() && this.dZi.aMn());
        }
    }
}
