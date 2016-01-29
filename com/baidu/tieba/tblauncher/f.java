package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        y yVar5;
        y yVar6;
        y yVar7;
        if (customResponsedMessage.getData() instanceof Integer) {
            Integer num = (Integer) customResponsedMessage.getData();
            if (num.intValue() == 2) {
                yVar6 = this.this$0.eaD;
                yVar6.ic(true);
                yVar7 = this.this$0.eaD;
                yVar7.eK(true);
            } else if (num.intValue() == 1) {
                yVar3 = this.this$0.eaD;
                yVar3.ic(true);
                yVar4 = this.this$0.eaD;
                yVar4.eK(false);
            } else {
                yVar = this.this$0.eaD;
                yVar.ic(false);
                yVar2 = this.this$0.eaD;
                yVar2.eK(false);
            }
            yVar5 = this.this$0.eaD;
            yVar5.aOo();
        }
    }
}
