package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ai aiVar;
        ai aiVar2;
        if (customResponsedMessage != null) {
            this.this$0.anV();
            if (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g) {
                this.this$0.a((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
            aiVar = this.this$0.cqV;
            aiVar.aor().aov();
            aiVar2 = this.this$0.cqV;
            aiVar2.aol();
        }
    }
}
