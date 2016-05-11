package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a eas;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.eas = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int intValue;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016327 && (customResponsedMessage.getData() instanceof Integer) && com.baidu.tieba.recommendfrs.control.a.q.aMp().cyC == (intValue = ((Integer) customResponsedMessage.getData()).intValue()) && intValue == com.baidu.tieba.recommendfrs.control.a.q.aMp().dZI && com.baidu.tieba.recommendfrs.control.a.q.aMp().dZJ != 0) {
            this.eas.iR(false);
        }
    }
}
