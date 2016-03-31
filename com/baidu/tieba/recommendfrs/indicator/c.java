package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.recommendfrs.control.a.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a dXj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.dXj = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int intValue;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016327 && (customResponsedMessage.getData() instanceof Integer) && q.aMe().cxD == (intValue = ((Integer) customResponsedMessage.getData()).intValue()) && intValue == q.aMe().dWy && q.aMe().dWz != 0) {
            this.dXj.ic(false);
        }
    }
}
