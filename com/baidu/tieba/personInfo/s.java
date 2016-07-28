package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(h hVar, int i) {
        super(i);
        this.this$0 = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bn bnVar;
        bn bnVar2;
        if (customResponsedMessage != null) {
            Long l = (Long) customResponsedMessage.getData();
            bnVar = this.this$0.ers;
            long c = com.baidu.adp.lib.h.b.c(bnVar.getId(), 0L);
            if (l != null && c == l.longValue()) {
                bnVar2 = this.this$0.ers;
                bnVar2.aPI();
            }
        }
    }
}
