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
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
            this.this$0.aKm();
            aeVar = this.this$0.fGw;
            if (aeVar != null) {
                aeVar2 = this.this$0.fGw;
                if (aeVar2.bnZ() != null) {
                    MainTabActivity mainTabActivity = this.this$0;
                    aeVar3 = this.this$0.fGw;
                    mainTabActivity.fGs = aeVar3.bnZ().getCurrentTabType();
                }
            }
            this.this$0.fGt = true;
        }
    }
}
