package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(PbActivity pbActivity, int i) {
        super(i);
        this.ciK = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cc ccVar;
        cc ccVar2;
        cc ccVar3;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            ccVar = this.ciK.cim;
            if (ccVar != null) {
                if (booleanValue) {
                    ccVar3 = this.ciK.cim;
                    ccVar3.Vw();
                    return;
                }
                ccVar2 = this.ciK.cim;
                ccVar2.Vv();
            }
        }
    }
}
