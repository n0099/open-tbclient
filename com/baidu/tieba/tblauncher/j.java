package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        ae aeVar4;
        ae aeVar5;
        ae aeVar6;
        ae aeVar7;
        if (customResponsedMessage.getData() instanceof Integer) {
            Integer num = (Integer) customResponsedMessage.getData();
            if (num.intValue() == 2) {
                aeVar6 = this.this$0.fGw;
                aeVar6.ls(true);
                aeVar7 = this.this$0.fGw;
                aeVar7.hK(true);
            } else if (num.intValue() == 1) {
                aeVar3 = this.this$0.fGw;
                aeVar3.ls(true);
                aeVar4 = this.this$0.fGw;
                aeVar4.hK(false);
            } else {
                aeVar = this.this$0.fGw;
                aeVar.ls(false);
                aeVar2 = this.this$0.fGw;
                aeVar2.hK(false);
            }
            aeVar5 = this.this$0.fGw;
            aeVar5.boa();
        }
    }
}
