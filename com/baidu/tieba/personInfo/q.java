package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(d dVar, int i) {
        super(i);
        this.cWV = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bb bbVar;
        bb bbVar2;
        if (customResponsedMessage != null) {
            Long l = (Long) customResponsedMessage.getData();
            bbVar = this.cWV.cRx;
            long c = com.baidu.adp.lib.h.b.c(bbVar.getId(), 0L);
            if (l != null && c == l.longValue()) {
                bbVar2 = this.cWV.cRx;
                bbVar2.aqu();
            }
        }
    }
}
