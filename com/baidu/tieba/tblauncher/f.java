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
        z zVar;
        z zVar2;
        z zVar3;
        z zVar4;
        z zVar5;
        z zVar6;
        z zVar7;
        if (customResponsedMessage.getData() instanceof Integer) {
            Integer num = (Integer) customResponsedMessage.getData();
            if (num.intValue() == 2) {
                zVar6 = this.this$0.fCk;
                zVar6.lB(true);
                zVar7 = this.this$0.fCk;
                zVar7.hJ(true);
            } else if (num.intValue() == 1) {
                zVar3 = this.this$0.fCk;
                zVar3.lB(true);
                zVar4 = this.this$0.fCk;
                zVar4.hJ(false);
            } else {
                zVar = this.this$0.fCk;
                zVar.lB(false);
                zVar2 = this.this$0.fCk;
                zVar2.hJ(false);
            }
            zVar5 = this.this$0.fCk;
            zVar5.bld();
        }
    }
}
