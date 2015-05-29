package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(PbActivity pbActivity, int i) {
        super(i);
        this.bKT = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ch chVar;
        ch chVar2;
        ch chVar3;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            chVar = this.bKT.bKz;
            if (chVar != null) {
                if (booleanValue) {
                    chVar3 = this.bKT.bKz;
                    chVar3.Td();
                    return;
                }
                chVar2 = this.bKT.bKz;
                chVar2.Tc();
            }
        }
    }
}
