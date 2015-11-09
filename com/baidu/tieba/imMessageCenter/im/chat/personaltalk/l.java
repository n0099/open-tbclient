package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.util.d<Boolean> {
    final /* synthetic */ j bKR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.bKR = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        long j;
        personalTalkSettingActivity = this.bKR.bKP;
        personalTalkSettingActivity.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
        personalTalkSettingActivity2 = this.bKR.bKP;
        personalTalkSettingActivity2.showToast(i.h.cash_del_suc, false);
        personalTalkSettingActivity3 = this.bKR.bKP;
        j = personalTalkSettingActivity3.userId;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(j), 2, null, 1)));
    }
}
