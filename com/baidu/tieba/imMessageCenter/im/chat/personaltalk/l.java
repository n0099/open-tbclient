package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ j dcl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.dcl = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        long j;
        personalTalkSettingActivity = this.dcl.dcj;
        personalTalkSettingActivity.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
        personalTalkSettingActivity2 = this.dcl.dcj;
        personalTalkSettingActivity2.showToast(u.j.cash_del_suc, false);
        personalTalkSettingActivity3 = this.dcl.dcj;
        j = personalTalkSettingActivity3.userId;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(j), 2, null, 1)));
    }
}
