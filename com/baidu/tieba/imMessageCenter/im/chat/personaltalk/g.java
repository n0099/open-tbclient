package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
/* loaded from: classes.dex */
class g extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonalTalkSettingActivity bsF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PersonalTalkSettingActivity personalTalkSettingActivity, int i) {
        super(i);
        this.bsF = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.bsF.closeLoadingDialog();
        if ((socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage)) {
            this.bsF.d(!((ResponseUpdateMaskInfoMessage) socketResponsedMessage).hasError(), ((RequestUpdateMaskInfoMessage) socketResponsedMessage.getOrginalMessage()).isSettingMask());
        }
    }
}
