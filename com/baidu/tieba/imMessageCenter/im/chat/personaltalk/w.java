package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.im.message.RequestQueryUserInfoMessage;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.im.g<PersonalSettingItemData> {
    private final /* synthetic */ long ayj;
    final /* synthetic */ s bqi;
    private final /* synthetic */ PersonalTalkSettingActivity bqj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bqi = sVar;
        this.ayj = j;
        this.bqj = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: a */
    public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.bqi.bqe = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.ayj);
        this.bqj.sendMessage(requestQueryUserInfoMessage);
    }
}
