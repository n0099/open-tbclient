package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ao aoVar;
        ao aoVar2;
        ao aoVar3;
        boolean booleanValue = customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : false;
        aoVar = this.this$0.deK;
        aoVar.dY(booleanValue);
        aoVar2 = this.this$0.deK;
        if (aoVar2.azM() != null) {
            aoVar3 = this.this$0.deK;
            aoVar3.azM().setEnabled(booleanValue ? false : true);
        }
    }
}
