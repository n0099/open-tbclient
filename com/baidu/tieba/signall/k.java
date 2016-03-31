package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity egh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.egh = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        af afVar;
        af afVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            afVar = this.egh.efZ;
            c aQm = afVar.aQm();
            if (aQm != null) {
                aQm.a((SignData) customResponsedMessage.getData());
                afVar2 = this.egh.efZ;
                afVar2.aQn().notifyDataSetChanged();
            }
        }
    }
}
