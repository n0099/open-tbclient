package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ai aiVar;
        ai aiVar2;
        ai aiVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
            this.this$0.arE();
            aiVar = this.this$0.cLT;
            if (aiVar != null) {
                aiVar2 = this.this$0.cLT;
                if (aiVar2.arW() != null) {
                    MainTabActivity mainTabActivity = this.this$0;
                    aiVar3 = this.this$0.cLT;
                    mainTabActivity.cLM = aiVar3.arW().getCurrentTabType();
                }
            }
            this.this$0.cLO = true;
        }
    }
}
