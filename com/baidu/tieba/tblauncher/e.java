package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
            this.this$0.atT();
            abVar = this.this$0.ewE;
            if (abVar != null) {
                abVar2 = this.this$0.ewE;
                if (abVar2.aVL() != null) {
                    MainTabActivity mainTabActivity = this.this$0;
                    abVar3 = this.this$0.ewE;
                    mainTabActivity.ewy = abVar3.aVL().getCurrentTabType();
                }
            }
            this.this$0.ewz = true;
        }
    }
}
