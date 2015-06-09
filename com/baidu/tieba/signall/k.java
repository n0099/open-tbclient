package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity cis;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.cis = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ae aeVar;
        ae aeVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            aeVar = this.cis.cik;
            c akX = aeVar.akX();
            if (akX != null) {
                akX.b((SignData) customResponsedMessage.getData());
                aeVar2 = this.cis.cik;
                aeVar2.akY().notifyDataSetChanged();
            }
        }
    }
}
