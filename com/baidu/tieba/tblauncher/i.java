package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ad adVar;
        ad adVar2;
        ad adVar3;
        ad adVar4;
        ad adVar5;
        ad adVar6;
        ad adVar7;
        if (customResponsedMessage.getData() instanceof Integer) {
            Integer num = (Integer) customResponsedMessage.getData();
            if (num.intValue() == 2) {
                adVar6 = this.this$0.fkF;
                adVar6.ld(true);
                adVar7 = this.this$0.fkF;
                adVar7.hy(true);
            } else if (num.intValue() == 1) {
                adVar3 = this.this$0.fkF;
                adVar3.ld(true);
                adVar4 = this.this$0.fkF;
                adVar4.hy(false);
            } else {
                adVar = this.this$0.fkF;
                adVar.ld(false);
                adVar2 = this.this$0.fkF;
                adVar2.hy(false);
            }
            adVar5 = this.this$0.fkF;
            adVar5.bhU();
        }
    }
}
