package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity bRc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.bRc = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ad adVar;
        ad adVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            adVar = this.bRc.bQV;
            b ael = adVar.ael();
            if (ael != null) {
                ael.b((SignData) customResponsedMessage.getData());
                adVar2 = this.bRc.bQV;
                adVar2.aem().notifyDataSetChanged();
            }
        }
    }
}
