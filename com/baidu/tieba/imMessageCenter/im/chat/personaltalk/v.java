package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.util.d<PersonalSettingItemData> {
    private final /* synthetic */ long aFz;
    final /* synthetic */ r bKY;
    private final /* synthetic */ PersonalTalkSettingActivity bKZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.bKY = rVar;
        this.aFz = j;
        this.bKZ = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: a */
    public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.bKY.bKU = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.aFz);
        this.bKZ.sendMessage(requestQueryUserInfoMessage);
    }
}
