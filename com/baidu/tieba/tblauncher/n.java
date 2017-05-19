package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ah ahVar;
        ah ahVar2;
        ah ahVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            int oldSkinType = TbadkCoreApplication.m9getInst().getOldSkinType();
            if (!((intValue == 2 || oldSkinType == 2) ? false : true)) {
                if ((intValue == 3 || intValue == 1 || intValue == 0) && oldSkinType == 2) {
                    ahVar3 = this.this$0.fyv;
                    ahVar3.biC().cv(1);
                } else if (TbadkCoreApplication.m9getInst().isThemeIconCover()) {
                    ahVar2 = this.this$0.fyv;
                    ahVar2.biC().cv(2);
                } else {
                    ahVar = this.this$0.fyv;
                    ahVar.biC().cv(1);
                }
            }
        }
    }
}
