package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(f fVar, int i) {
        super(i);
        this.this$0 = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bg bgVar;
        bg bgVar2;
        if (customResponsedMessage != null) {
            Long l = (Long) customResponsedMessage.getData();
            bgVar = this.this$0.dyP;
            long c = com.baidu.adp.lib.h.b.c(bgVar.getId(), 0L);
            if (l != null && c == l.longValue()) {
                bgVar2 = this.this$0.dyP;
                bgVar2.aDF();
            }
        }
    }
}
