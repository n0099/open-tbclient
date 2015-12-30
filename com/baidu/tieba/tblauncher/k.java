package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        w wVar;
        w wVar2;
        w wVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            int oldSkinType = TbadkCoreApplication.m411getInst().getOldSkinType();
            if (!((intValue == 2 || oldSkinType == 2) ? false : true)) {
                if ((intValue == 3 || intValue == 1 || intValue == 0) && oldSkinType == 2) {
                    wVar3 = this.this$0.dKy;
                    wVar3.aHi().cc(1);
                } else if (TbadkCoreApplication.m411getInst().isThemeIconCover()) {
                    wVar2 = this.this$0.dKy;
                    wVar2.aHi().cc(2);
                } else {
                    wVar = this.this$0.dKy;
                    wVar.aHi().cc(1);
                }
            }
        }
    }
}
