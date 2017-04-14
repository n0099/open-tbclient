package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.util.f<PersonalSettingItemData> {
    private final /* synthetic */ long aYe;
    final /* synthetic */ r dil;
    private final /* synthetic */ PersonalTalkSettingActivity dim;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.dil = rVar;
        this.aYe = j;
        this.dim = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    /* renamed from: a */
    public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.dil.dih = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.aYe);
        this.dim.sendMessage(requestQueryUserInfoMessage);
    }
}
