package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.g;
/* loaded from: classes.dex */
class ad extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ai aiVar;
        ai aiVar2;
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getData() instanceof g) {
                this.this$0.a((g) customResponsedMessage.getData());
            }
            aiVar = this.this$0.ccK;
            aiVar.ajB().ajH();
            aiVar2 = this.this$0.ccK;
            aiVar2.ajx();
        }
    }
}
