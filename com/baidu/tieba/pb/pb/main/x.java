package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(PbActivity pbActivity, int i) {
        super(i);
        this.ccj = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cb cbVar;
        cb cbVar2;
        cb cbVar3;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            cbVar = this.ccj.cbL;
            if (cbVar != null) {
                if (booleanValue) {
                    cbVar3 = this.ccj.cbL;
                    cbVar3.UN();
                    return;
                }
                cbVar2 = this.ccj.cbL;
                cbVar2.UM();
            }
        }
    }
}
