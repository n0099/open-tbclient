package com.baidu.tieba.recommendfrs.indicator;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.recommendfrs.control.a.q;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ ScrollFragmentTabHost dXs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
        super(i);
        this.dXs = scrollFragmentTabHost;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        i iVar;
        i iVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016326 && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            iVar = this.dXs.dXk;
            if (iVar != null) {
                iVar2 = this.dXs.dXk;
                iVar2.aU(q.aMe().dWy, intValue);
            }
        }
    }
}
