package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ak akVar;
        ak akVar2;
        ak akVar3;
        ak akVar4;
        ak akVar5;
        ak akVar6;
        ak akVar7;
        if (customResponsedMessage.getData() instanceof Integer) {
            Integer num = (Integer) customResponsedMessage.getData();
            if (num.intValue() == 2) {
                akVar6 = this.this$0.fGm;
                akVar6.lB(true);
                akVar7 = this.this$0.fGm;
                akVar7.hx(true);
            } else if (num.intValue() == 1) {
                akVar3 = this.this$0.fGm;
                akVar3.lB(true);
                akVar4 = this.this$0.fGm;
                akVar4.hx(false);
            } else {
                akVar = this.this$0.fGm;
                akVar.lB(false);
                akVar2 = this.this$0.fGm;
                akVar2.hx(false);
            }
            akVar5 = this.this$0.fGm;
            akVar5.bkb();
        }
    }
}
