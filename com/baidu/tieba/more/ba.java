package com.baidu.tieba.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ SystemHelpSettingActivity byd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.byd = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.byd.closeLoadingDialog();
        this.byd.showToast(com.baidu.tieba.z.systemhelpsetting_clear_im_success);
    }
}
