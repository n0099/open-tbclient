package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity dNI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.dNI = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        af afVar;
        af afVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            afVar = this.dNI.dNA;
            c aJv = afVar.aJv();
            if (aJv != null) {
                aJv.b((SignData) customResponsedMessage.getData());
                afVar2 = this.dNI.dNA;
                afVar2.aJw().notifyDataSetChanged();
            }
        }
    }
}
