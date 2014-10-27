package com.baidu.tieba.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ SystemHelpSettingActivity bsJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.bsJ = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.bsJ.closeLoadingDialog();
        this.bsJ.showToast(com.baidu.tieba.y.systemhelpsetting_clear_im_success);
    }
}
