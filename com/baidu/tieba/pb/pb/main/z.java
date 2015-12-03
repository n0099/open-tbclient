package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(PbActivity pbActivity, int i) {
        super(i);
        this.cCm = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        da daVar;
        da daVar2;
        da daVar3;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            daVar = this.cCm.cBL;
            if (daVar != null) {
                if (booleanValue) {
                    daVar3 = this.cCm.cBL;
                    daVar3.YT();
                    return;
                }
                daVar2 = this.cCm.cBL;
                daVar2.YS();
            }
        }
    }
}
