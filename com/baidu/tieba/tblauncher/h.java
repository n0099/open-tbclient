package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        ab abVar5;
        ab abVar6;
        ab abVar7;
        if (customResponsedMessage.getData() instanceof Integer) {
            Integer num = (Integer) customResponsedMessage.getData();
            if (num.intValue() == 2) {
                abVar6 = this.this$0.ewE;
                abVar6.jF(true);
                abVar7 = this.this$0.ewE;
                abVar7.fX(true);
            } else if (num.intValue() == 1) {
                abVar3 = this.this$0.ewE;
                abVar3.jF(true);
                abVar4 = this.this$0.ewE;
                abVar4.fX(false);
            } else {
                abVar = this.this$0.ewE;
                abVar.jF(false);
                abVar2 = this.this$0.ewE;
                abVar2.fX(false);
            }
            abVar5 = this.this$0.ewE;
            abVar5.aVM();
        }
    }
}
