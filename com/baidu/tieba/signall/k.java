package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity bLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.bLc = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ab abVar;
        ab abVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            abVar = this.bLc.bKV;
            b adj = abVar.adj();
            if (adj != null) {
                adj.c((SignData) customResponsedMessage.getData());
                abVar2 = this.bLc.bKV;
                abVar2.adk().notifyDataSetChanged();
            }
        }
    }
}
