package com.baidu.tieba.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ao extends CustomMessageListener {
    final /* synthetic */ SystemHelpSettingActivity bwu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.bwu = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.bwu.closeLoadingDialog();
        this.bwu.showToast(com.baidu.tieba.z.systemhelpsetting_clear_im_success);
    }
}
