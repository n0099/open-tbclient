package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tieba.im.message.ClearChatMsgResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ k bpL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.bpL = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        PersonalTalkSettingActivity personalTalkSettingActivity;
        PersonalTalkSettingActivity personalTalkSettingActivity2;
        PersonalTalkSettingActivity personalTalkSettingActivity3;
        long j;
        PersonalTalkSettingActivity personalTalkSettingActivity4;
        long j2;
        personalTalkSettingActivity = this.bpL.bpK;
        personalTalkSettingActivity.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ClearChatMsgResponsedMessage());
        personalTalkSettingActivity2 = this.bpL.bpK;
        personalTalkSettingActivity2.showToast(com.baidu.tieba.y.cash_del_suc, false);
        personalTalkSettingActivity3 = this.bpL.bpK;
        j = personalTalkSettingActivity3.userId;
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.g(String.valueOf(j), 2, null, 1)));
        StringBuilder sb = new StringBuilder("clear cache by person:");
        personalTalkSettingActivity4 = this.bpL.bpK;
        j2 = personalTalkSettingActivity4.userId;
        BdSocketLinkService.startService(true, sb.append(j2).toString());
    }
}
