package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ao aoVar;
        ao aoVar2;
        ao aoVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
            this.this$0.initTabsOnActivityCreated();
            aoVar = this.this$0.deK;
            if (aoVar != null) {
                aoVar2 = this.this$0.deK;
                if (aoVar2.azL() != null) {
                    MainTabActivity mainTabActivity = this.this$0;
                    aoVar3 = this.this$0.deK;
                    mainTabActivity.deE = aoVar3.azL().getCurrentTabType();
                }
            }
            this.this$0.deF = true;
        }
    }
}
