package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.util.d<PersonalSettingItemData> {
    private final /* synthetic */ long aJW;
    final /* synthetic */ r ced;
    private final /* synthetic */ PersonalTalkSettingActivity cee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.ced = rVar;
        this.aJW = j;
        this.cee = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: a */
    public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.ced.cdZ = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.aJW);
        this.cee.sendMessage(requestQueryUserInfoMessage);
    }
}
