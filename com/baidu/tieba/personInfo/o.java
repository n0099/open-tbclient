package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(d dVar, int i) {
        super(i);
        this.cSn = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aw awVar;
        aw awVar2;
        if (customResponsedMessage != null) {
            Long l = (Long) customResponsedMessage.getData();
            awVar = this.cSn.cMT;
            long c = com.baidu.adp.lib.h.b.c(awVar.getId(), 0L);
            if (l != null && c == l.longValue()) {
                awVar2 = this.cSn.cMT;
                awVar2.aph();
            }
        }
    }
}
