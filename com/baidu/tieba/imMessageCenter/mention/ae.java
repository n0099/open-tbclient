package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ae extends CustomMessageListener {
    final /* synthetic */ ad dhd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(ad adVar, int i) {
        super(i);
        this.dhd = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            lVar = this.dhd.dha;
            if (lVar != null) {
                lVar5 = this.dhd.dha;
                lVar5.ge(true);
            }
            MentionActivityConfig.newJumpIn = true;
            lVar2 = this.dhd.dha;
            if (lVar2 != null) {
                lVar3 = this.dhd.dha;
                lVar3.aaS();
                lVar4 = this.dhd.dha;
                lVar4.r(TbadkCoreApplication.isLogin(), TbadkCoreApplication.isLogin() ? false : true);
            }
        }
    }
}
