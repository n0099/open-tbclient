package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.bJY = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        v vVar;
        v vVar2;
        if (customResponsedMessage != null) {
            Long l = (Long) customResponsedMessage.getData();
            vVar = this.bJY.bJN;
            long a = com.baidu.adp.lib.g.c.a(vVar.getId(), 0L);
            if (l != null && a == l.longValue()) {
                vVar2 = this.bJY.bJN;
                vVar2.acc();
            }
        }
    }
}
