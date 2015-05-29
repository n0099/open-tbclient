package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class au extends CustomMessageListener {
    final /* synthetic */ SystemHelpSettingActivity cgQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.cgQ = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.cgQ.closeLoadingDialog();
        this.cgQ.showToast(com.baidu.tieba.t.systemhelpsetting_clear_im_success);
    }
}
