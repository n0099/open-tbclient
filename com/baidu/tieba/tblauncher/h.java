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
        ac acVar;
        ac acVar2;
        ac acVar3;
        ac acVar4;
        ac acVar5;
        ac acVar6;
        ac acVar7;
        if (customResponsedMessage.getData() instanceof Integer) {
            Integer num = (Integer) customResponsedMessage.getData();
            if (num.intValue() == 2) {
                acVar6 = this.this$0.fwr;
                acVar6.kQ(true);
                acVar7 = this.this$0.fwr;
                acVar7.ho(true);
            } else if (num.intValue() == 1) {
                acVar3 = this.this$0.fwr;
                acVar3.kQ(true);
                acVar4 = this.this$0.fwr;
                acVar4.ho(false);
            } else {
                acVar = this.this$0.fwr;
                acVar.kQ(false);
                acVar2 = this.this$0.fwr;
                acVar2.ho(false);
            }
            acVar5 = this.this$0.fwr;
            acVar5.bla();
        }
    }
}
