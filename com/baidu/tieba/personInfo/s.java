package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(f fVar, int i) {
        super(i);
        this.diG = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bf bfVar;
        bf bfVar2;
        if (customResponsedMessage != null) {
            Long l = (Long) customResponsedMessage.getData();
            bfVar = this.diG.dbl;
            long c = com.baidu.adp.lib.h.b.c(bfVar.getId(), 0L);
            if (l != null && c == l.longValue()) {
                bfVar2 = this.diG.dbl;
                bfVar2.avF();
            }
        }
    }
}
