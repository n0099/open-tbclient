package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity bRb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.bRb = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ad adVar;
        ad adVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            adVar = this.bRb.bQU;
            b aeg = adVar.aeg();
            if (aeg != null) {
                aeg.b((SignData) customResponsedMessage.getData());
                adVar2 = this.bRb.bQU;
                adVar2.aeh().notifyDataSetChanged();
            }
        }
    }
}
