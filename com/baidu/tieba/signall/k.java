package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity dxE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.dxE = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ae aeVar;
        ae aeVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            aeVar = this.dxE.dxw;
            c aCn = aeVar.aCn();
            if (aCn != null) {
                aCn.b((SignData) customResponsedMessage.getData());
                aeVar2 = this.dxE.dxw;
                aeVar2.aCo().notifyDataSetChanged();
            }
        }
    }
}
