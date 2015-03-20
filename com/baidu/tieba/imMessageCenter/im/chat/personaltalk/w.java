package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.im.message.RequestQueryUserInfoMessage;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.im.g<PersonalSettingItemData> {
    private final /* synthetic */ long ayb;
    final /* synthetic */ s bpS;
    private final /* synthetic */ PersonalTalkSettingActivity bpT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bpS = sVar;
        this.ayb = j;
        this.bpT = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: a */
    public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.bpS.bpO = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.ayb);
        this.bpT.sendMessage(requestQueryUserInfoMessage);
    }
}
