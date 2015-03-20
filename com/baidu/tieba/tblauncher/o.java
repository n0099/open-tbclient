package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ai aiVar;
        ai aiVar2;
        ai aiVar3;
        boolean booleanValue = customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false;
        aiVar = this.this$0.cqV;
        aiVar.eX(booleanValue);
        aiVar2 = this.this$0.cqV;
        if (aiVar2.aoq() != null) {
            aiVar3 = this.this$0.cqV;
            aiVar3.aoq().setEnabled(booleanValue ? false : true);
        }
    }
}
