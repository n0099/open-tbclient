package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class at extends CustomMessageListener {
    final /* synthetic */ SystemHelpSettingActivity dvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.dvU = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.dvU.closeLoadingDialog();
        this.dvU.showToast(n.j.systemhelpsetting_clear_im_success);
    }
}
