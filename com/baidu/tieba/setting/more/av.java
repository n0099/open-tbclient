package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class av extends CustomMessageListener {
    final /* synthetic */ SystemHelpSettingActivity eey;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.eey = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.eey.closeLoadingDialog();
        this.eey.showToast(t.j.systemhelpsetting_clear_im_success);
    }
}
