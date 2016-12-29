package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class u extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ad adVar;
        ad adVar2;
        ad adVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
            this.this$0.aEn();
            adVar = this.this$0.fkF;
            if (adVar != null) {
                adVar2 = this.this$0.fkF;
                if (adVar2.bhT() != null) {
                    MainTabActivity mainTabActivity = this.this$0;
                    adVar3 = this.this$0.fkF;
                    mainTabActivity.fkB = adVar3.bhT().getCurrentTabType();
                }
            }
            this.this$0.fkC = true;
        }
    }
}
