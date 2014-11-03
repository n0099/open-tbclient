package com.baidu.tieba.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ SingleMentionActivity bom;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(SingleMentionActivity singleMentionActivity, int i) {
        super(i);
        this.bom = singleMentionActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001229 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.model.am)) {
            com.baidu.tieba.model.am amVar = (com.baidu.tieba.model.am) customResponsedMessage.getData();
            if (amVar.isSucc() && this.bom.boj != null && this.bom.boj.ST() != null) {
                this.bom.boj.ST().b(amVar);
            }
        }
    }
}
