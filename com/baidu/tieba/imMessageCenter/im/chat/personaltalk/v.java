package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.util.g<PersonalSettingItemData> {
    private final /* synthetic */ long aKh;
    final /* synthetic */ r cuf;
    private final /* synthetic */ PersonalTalkSettingActivity cug;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.cuf = rVar;
        this.aKh = j;
        this.cug = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: a */
    public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.cuf.cub = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.aKh);
        this.cug.sendMessage(requestQueryUserInfoMessage);
    }
}
