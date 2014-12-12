package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity bPs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.bPs = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ad adVar;
        ad adVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            adVar = this.bPs.bPl;
            b adH = adVar.adH();
            if (adH != null) {
                adH.b((SignData) customResponsedMessage.getData());
                adVar2 = this.bPs.bPl;
                adVar2.adI().notifyDataSetChanged();
            }
        }
    }
}
