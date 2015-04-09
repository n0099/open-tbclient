package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(PbActivity pbActivity, int i) {
        super(i);
        this.bIJ = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            cjVar = this.bIJ.bIl;
            if (cjVar != null) {
                if (booleanValue) {
                    cjVar3 = this.bIJ.bIl;
                    cjVar3.RQ();
                    return;
                }
                cjVar2 = this.bIJ.bIl;
                cjVar2.RP();
            }
        }
    }
}
