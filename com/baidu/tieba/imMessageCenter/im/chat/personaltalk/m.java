package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ k bsG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.bsG = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        long j;
        personalTalkSettingActivity = this.bsG.bsF;
        personalTalkSettingActivity.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
        personalTalkSettingActivity2 = this.bsG.bsF;
        personalTalkSettingActivity2.showToast(com.baidu.tieba.t.cash_del_suc, false);
        personalTalkSettingActivity3 = this.bsG.bsF;
        j = personalTalkSettingActivity3.userId;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.g(String.valueOf(j), 2, null, 1)));
    }
}
