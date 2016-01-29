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
        y yVar;
        y yVar2;
        y yVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
            this.this$0.amV();
            yVar = this.this$0.eaD;
            if (yVar != null) {
                yVar2 = this.this$0.eaD;
                if (yVar2.aOn() != null) {
                    MainTabActivity mainTabActivity = this.this$0;
                    yVar3 = this.this$0.eaD;
                    mainTabActivity.eax = yVar3.aOn().getCurrentTabType();
                }
            }
            this.this$0.eay = true;
        }
    }
}
