package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class at extends CustomMessageListener {
    final /* synthetic */ SystemHelpSettingActivity cbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.cbY = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.cbY.closeLoadingDialog();
        this.cbY.showToast(com.baidu.tieba.y.systemhelpsetting_clear_im_success);
    }
}
