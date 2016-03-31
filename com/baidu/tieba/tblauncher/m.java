package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aa aaVar;
        aa aaVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001378) {
            aaVar = this.this$0.etw;
            if (aaVar.aVp().getCurrentTabType() == 1) {
                aaVar2 = this.this$0.etw;
                aaVar2.iT(true);
            }
        }
    }
}
