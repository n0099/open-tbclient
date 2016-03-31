package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        aa aaVar4;
        aa aaVar5;
        aa aaVar6;
        aa aaVar7;
        if (customResponsedMessage.getData() instanceof Integer) {
            Integer num = (Integer) customResponsedMessage.getData();
            if (num.intValue() == 2) {
                aaVar6 = this.this$0.etw;
                aaVar6.iS(true);
                aaVar7 = this.this$0.etw;
                aaVar7.fx(true);
            } else if (num.intValue() == 1) {
                aaVar3 = this.this$0.etw;
                aaVar3.iS(true);
                aaVar4 = this.this$0.etw;
                aaVar4.fx(false);
            } else {
                aaVar = this.this$0.etw;
                aaVar.iS(false);
                aaVar2 = this.this$0.etw;
                aaVar2.fx(false);
            }
            aaVar5 = this.this$0.etw;
            aaVar5.aVq();
        }
    }
}
