package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aj ajVar;
        aj ajVar2;
        aj ajVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
            this.this$0.aqd();
            ajVar = this.this$0.cvr;
            if (ajVar != null) {
                ajVar2 = this.this$0.cvr;
                if (ajVar2.aqu() != null) {
                    MainTabActivity mainTabActivity = this.this$0;
                    ajVar3 = this.this$0.cvr;
                    mainTabActivity.cvk = ajVar3.aqu().getCurrentTabType();
                }
            }
            this.this$0.cvm = true;
        }
    }
}
