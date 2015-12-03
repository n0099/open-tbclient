package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class as extends CustomMessageListener {
    final /* synthetic */ SystemHelpSettingActivity doH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.doH = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.doH.closeLoadingDialog();
        this.doH.showToast(n.i.systemhelpsetting_clear_im_success);
    }
}
