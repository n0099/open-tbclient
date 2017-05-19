package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ah ahVar;
        ah ahVar2;
        ah ahVar3;
        ah ahVar4;
        ah ahVar5;
        ah ahVar6;
        ah ahVar7;
        if (customResponsedMessage.getData() instanceof Integer) {
            Integer num = (Integer) customResponsedMessage.getData();
            if (num.intValue() == 2) {
                ahVar6 = this.this$0.fyv;
                ahVar6.lg(true);
                ahVar7 = this.this$0.fyv;
                ahVar7.hk(true);
            } else if (num.intValue() == 1) {
                ahVar3 = this.this$0.fyv;
                ahVar3.lg(true);
                ahVar4 = this.this$0.fyv;
                ahVar4.hk(false);
            } else {
                ahVar = this.this$0.fyv;
                ahVar.lg(false);
                ahVar2 = this.this$0.fyv;
                ahVar2.hk(false);
            }
            ahVar5 = this.this$0.fyv;
            ahVar5.biD();
        }
    }
}
