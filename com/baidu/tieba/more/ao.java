package com.baidu.tieba.more;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ao extends CustomMessageListener {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(SystemHelpSettingActivity systemHelpSettingActivity, int i) {
        super(i);
        this.a = systemHelpSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        this.a.closeLoadingDialog();
        this.a.showToast(com.baidu.tieba.x.systemhelpsetting_clear_im_success);
    }
}
