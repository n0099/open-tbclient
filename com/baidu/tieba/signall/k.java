package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity ejs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.ejs = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        af afVar;
        af afVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            afVar = this.ejs.ejk;
            c aQF = afVar.aQF();
            if (aQF != null) {
                aQF.a((SignData) customResponsedMessage.getData());
                afVar2 = this.ejs.ejk;
                afVar2.aQG().notifyDataSetChanged();
            }
        }
    }
}
