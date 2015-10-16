package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.i;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.util.d<Boolean> {
    final /* synthetic */ j bKw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.bKw = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        long j;
        personalTalkSettingActivity = this.bKw.bKu;
        personalTalkSettingActivity.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
        personalTalkSettingActivity2 = this.bKw.bKu;
        personalTalkSettingActivity2.showToast(i.h.cash_del_suc, false);
        personalTalkSettingActivity3 = this.bKw.bKu;
        j = personalTalkSettingActivity3.userId;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(j), 2, null, 1)));
    }
}
