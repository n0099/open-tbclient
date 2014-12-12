package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class af extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        an anVar;
        an anVar2;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g) {
                this.this$0.a((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
            anVar = this.this$0.caU;
            anVar.aja().ajl();
            anVar2 = this.this$0.caU;
            anVar2.aiV();
        }
    }
}
