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
            if ((intValue == 3 || intValue == 1 || intValue == 0) && TbadkCoreApplication.m411getInst().getOldSkinType() == 2) {
                wVar3 = this.this$0.dCW;
                wVar3.aEU().cj(1);
            } else if (TbadkCoreApplication.m411getInst().isThemeIconCover()) {
                wVar2 = this.this$0.dCW;
                wVar2.aEU().cj(2);
            } else {
                wVar = this.this$0.dCW;
                wVar.aEU().cj(1);
            }
        }
    }
}
