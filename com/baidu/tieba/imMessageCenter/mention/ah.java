package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends CustomMessageListener {
    final /* synthetic */ ag dcE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ag agVar, int i) {
        super(i);
        this.dcE = agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            oVar = this.dcE.dcB;
            if (oVar != null) {
                oVar4 = this.dcE.dcB;
                oVar4.gz(true);
            }
            MentionActivityConfig.newJumpIn = true;
            oVar2 = this.dcE.dcB;
            if (oVar2 != null) {
                oVar3 = this.dcE.dcB;
                oVar3.Zi();
            }
        }
    }
}
