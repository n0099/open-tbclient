package com.baidu.tieba.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ SystemHelpSettingActivity bsX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.bsX = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.bsX.closeLoadingDialog();
        this.bsX.showToast(com.baidu.tieba.y.systemhelpsetting_clear_im_success);
    }
}
