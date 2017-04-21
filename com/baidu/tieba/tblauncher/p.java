package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        z zVar;
        z zVar2;
        z zVar3;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007013) {
            this.this$0.aGl();
            zVar = this.this$0.fCk;
            if (zVar != null) {
                zVar2 = this.this$0.fCk;
                if (zVar2.blc() != null) {
                    MainTabActivity mainTabActivity = this.this$0;
                    zVar3 = this.this$0.fCk;
                    mainTabActivity.fCg = zVar3.blc().getCurrentTabType();
                }
            }
            this.this$0.fCh = true;
        }
    }
}
