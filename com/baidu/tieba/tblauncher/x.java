package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ao aoVar;
        ao aoVar2;
        ao aoVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if ((intValue == 3 || intValue == 1 || intValue == 0) && TbadkCoreApplication.m411getInst().getOldSkinType() == 2) {
                aoVar3 = this.this$0.dcb;
                aoVar3.ayy().cb(1);
            } else if (TbadkCoreApplication.m411getInst().isThemeIconCover()) {
                aoVar2 = this.this$0.dcb;
                aoVar2.ayy().cb(2);
            } else {
                aoVar = this.this$0.dcb;
                aoVar.ayy().cb(1);
            }
        }
    }
}
