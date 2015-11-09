package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(PbActivity pbActivity, int i) {
        super(i);
        this.cjN = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            ctVar = this.cjN.cjo;
            if (ctVar != null) {
                if (booleanValue) {
                    ctVar3 = this.cjN.cjo;
                    ctVar3.VN();
                    return;
                }
                ctVar2 = this.cjN.cjo;
                ctVar2.VM();
            }
        }
    }
}
