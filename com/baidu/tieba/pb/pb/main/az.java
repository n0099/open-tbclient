package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class az extends CustomMessageListener {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(PbActivity pbActivity, int i) {
        super(i);
        this.djE = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        el elVar;
        el elVar2;
        el elVar3;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            elVar = this.djE.diR;
            if (elVar != null) {
                if (booleanValue) {
                    elVar3 = this.djE.diR;
                    elVar3.agq();
                    return;
                }
                elVar2 = this.djE.diR;
                elVar2.agp();
            }
        }
    }
}
