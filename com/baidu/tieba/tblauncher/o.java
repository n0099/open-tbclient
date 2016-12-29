package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ad adVar;
        ad adVar2;
        ad adVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            int oldSkinType = TbadkCoreApplication.m9getInst().getOldSkinType();
            if (!((intValue == 2 || oldSkinType == 2) ? false : true)) {
                if ((intValue == 3 || intValue == 1 || intValue == 0) && oldSkinType == 2) {
                    adVar3 = this.this$0.fkF;
                    adVar3.bhT().cz(1);
                } else if (TbadkCoreApplication.m9getInst().isThemeIconCover()) {
                    adVar2 = this.this$0.fkF;
                    adVar2.bhT().cz(2);
                } else {
                    adVar = this.this$0.fkF;
                    adVar.bhT().cz(1);
                }
            }
        }
    }
}
