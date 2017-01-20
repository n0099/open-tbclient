package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends CustomMessageListener {
    final /* synthetic */ ad djP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(ad adVar, int i) {
        super(i);
        this.djP = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            lVar = this.djP.djM;
            if (lVar != null) {
                lVar4 = this.djP.djM;
                lVar4.gC(true);
            }
            MentionActivityConfig.newJumpIn = true;
            lVar2 = this.djP.djM;
            if (lVar2 != null) {
                lVar3 = this.djP.djM;
                lVar3.aak();
            }
        }
    }
}
