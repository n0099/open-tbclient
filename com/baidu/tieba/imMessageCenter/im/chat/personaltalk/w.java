package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.im.message.RequestQueryUserInfoMessage;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.im.g<PersonalSettingItemData> {
    private final /* synthetic */ long azU;
    final /* synthetic */ s bsN;
    private final /* synthetic */ PersonalTalkSettingActivity bsO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bsN = sVar;
        this.azU = j;
        this.bsO = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: a */
    public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.bsN.bsJ = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.azU);
        this.bsO.sendMessage(requestQueryUserInfoMessage);
    }
}
