package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.im.message.RequestQueryUserInfoMessage;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.im.g<PersonalSettingItemData> {
    private final /* synthetic */ long azV;
    final /* synthetic */ s bsO;
    private final /* synthetic */ PersonalTalkSettingActivity bsP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bsO = sVar;
        this.azV = j;
        this.bsP = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: a */
    public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.bsO.bsK = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.azV);
        this.bsP.sendMessage(requestQueryUserInfoMessage);
    }
}
