package com.baidu.tieba.write.vote;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class i extends CustomMessageListener {
    final /* synthetic */ WriteVoteActivity erf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(WriteVoteActivity writeVoteActivity, int i) {
        super(i);
        this.erf = writeVoteActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        n nVar;
        n nVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001364) {
            nVar = this.erf.eqX;
            if (nVar != null) {
                nVar2 = this.erf.eqX;
                nVar2.iD(true);
            }
        }
    }
}
