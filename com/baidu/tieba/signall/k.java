package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity cdX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.cdX = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ae aeVar;
        ae aeVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            aeVar = this.cdX.cdP;
            c aiX = aeVar.aiX();
            if (aiX != null) {
                aiX.b((SignData) customResponsedMessage.getData());
                aeVar2 = this.cdX.cdP;
                aeVar2.aiY().notifyDataSetChanged();
            }
        }
    }
}
