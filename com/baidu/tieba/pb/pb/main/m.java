package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(PbActivity pbActivity, int i) {
        super(i);
        this.bIv = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            ciVar = this.bIv.bHY;
            if (ciVar != null) {
                if (booleanValue) {
                    ciVar3 = this.bIv.bHY;
                    ciVar3.RD();
                    return;
                }
                ciVar2 = this.bIv.bHY;
                ciVar2.RC();
            }
        }
    }
}
