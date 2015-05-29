package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity cir;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.cir = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ae aeVar;
        ae aeVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            aeVar = this.cir.cij;
            c akW = aeVar.akW();
            if (akW != null) {
                akW.b((SignData) customResponsedMessage.getData());
                aeVar2 = this.cir.cij;
                aeVar2.akX().notifyDataSetChanged();
            }
        }
    }
}
