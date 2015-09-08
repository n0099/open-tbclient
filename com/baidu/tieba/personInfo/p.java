package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity cmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.cmR = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        w wVar;
        w wVar2;
        if (customResponsedMessage != null) {
            Long l = (Long) customResponsedMessage.getData();
            wVar = this.cmR.cmF;
            long c = com.baidu.adp.lib.g.b.c(wVar.getId(), 0L);
            if (l != null && c == l.longValue()) {
                wVar2 = this.cmR.cmF;
                wVar2.ahT();
            }
        }
    }
}
