package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class r extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity cue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.cue = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        if (customResponsedMessage != null) {
            Long l = (Long) customResponsedMessage.getData();
            yVar = this.cue.ctR;
            long c = com.baidu.adp.lib.g.b.c(yVar.getId(), 0L);
            if (l != null && c == l.longValue()) {
                yVar2 = this.cue.ctR;
                yVar2.akw();
            }
        }
    }
}
