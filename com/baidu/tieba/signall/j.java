package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity dqq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.dqq = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        z zVar;
        z zVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
            zVar = this.dqq.dqi;
            c aAf = zVar.aAf();
            if (aAf != null) {
                aAf.b((SignData) customResponsedMessage.getData());
                zVar2 = this.dqq.dqi;
                zVar2.aAg().notifyDataSetChanged();
            }
        }
    }
}
