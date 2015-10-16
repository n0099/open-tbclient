package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ah extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ao aoVar;
        ao aoVar2;
        if (customResponsedMessage != null) {
            this.this$0.ayn();
            if (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.e) {
                this.this$0.a((com.baidu.tbadk.data.e) customResponsedMessage.getData());
            }
            aoVar = this.this$0.dcB;
            aoVar.ayK().ayV();
            aoVar2 = this.this$0.dcB;
            aoVar2.ayF();
        }
    }
}
