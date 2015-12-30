package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        w wVar;
        w wVar2;
        w wVar3;
        w wVar4;
        w wVar5;
        w wVar6;
        w wVar7;
        if (customResponsedMessage.getData() instanceof Integer) {
            Integer num = (Integer) customResponsedMessage.getData();
            if (num.intValue() == 2) {
                wVar6 = this.this$0.dKy;
                wVar6.hA(true);
                wVar7 = this.this$0.dKy;
                wVar7.ex(true);
            } else if (num.intValue() == 1) {
                wVar3 = this.this$0.dKy;
                wVar3.hA(true);
                wVar4 = this.this$0.dKy;
                wVar4.ex(false);
            } else {
                wVar = this.this$0.dKy;
                wVar.hA(false);
                wVar2 = this.this$0.dKy;
                wVar2.ex(false);
            }
            wVar5 = this.this$0.dKy;
            wVar5.aHj();
        }
    }
}
