package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.util.g<PersonalSettingItemData> {
    private final /* synthetic */ long aNF;
    final /* synthetic */ r cZu;
    private final /* synthetic */ PersonalTalkSettingActivity cZv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.cZu = rVar;
        this.aNF = j;
        this.cZv = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: a */
    public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.cZu.cZq = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.aNF);
        this.cZv.sendMessage(requestQueryUserInfoMessage);
    }
}
