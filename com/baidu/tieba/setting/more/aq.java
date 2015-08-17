package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class aq extends CustomMessageListener {
    final /* synthetic */ SystemHelpSettingActivity cyR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.cyR = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.cyR.closeLoadingDialog();
        this.cyR.showToast(i.C0057i.systemhelpsetting_clear_im_success);
    }
}
