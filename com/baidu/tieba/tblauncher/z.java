package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ak akVar;
        ak akVar2;
        ak akVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
            this.this$0.aEp();
            akVar = this.this$0.fGm;
            if (akVar != null) {
                akVar2 = this.this$0.fGm;
                if (akVar2.bka() != null) {
                    MainTabActivity mainTabActivity = this.this$0;
                    akVar3 = this.this$0.fGm;
                    mainTabActivity.fGh = akVar3.bka().getCurrentTabType();
                }
            }
            this.this$0.fGi = true;
        }
    }
}
