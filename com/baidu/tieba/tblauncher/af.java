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
        am amVar;
        am amVar2;
        am amVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
            this.this$0.initTabsOnActivityCreated();
            amVar = this.this$0.cUv;
            if (amVar != null) {
                amVar2 = this.this$0.cUv;
                if (amVar2.awj() != null) {
                    MainTabActivity mainTabActivity = this.this$0;
                    amVar3 = this.this$0.cUv;
                    mainTabActivity.cUo = amVar3.awj().getCurrentTabType();
                }
            }
            this.this$0.cUq = true;
        }
    }
}
