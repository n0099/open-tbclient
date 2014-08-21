package com.baidu.tieba.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class aw extends CustomMessageListener {
    final /* synthetic */ SingleMentionActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(SingleMentionActivity singleMentionActivity, int i) {
        super(i);
        this.a = singleMentionActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001229 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.model.al)) {
            com.baidu.tieba.model.al alVar = (com.baidu.tieba.model.al) customResponsedMessage.getData();
            if (alVar.a() && this.a.d != null && this.a.d.a() != null) {
                this.a.d.a().a(alVar);
            }
        }
    }
}
