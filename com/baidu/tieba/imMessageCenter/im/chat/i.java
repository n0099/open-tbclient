package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class i extends com.baidu.tbadk.util.m<Boolean> {
    private final /* synthetic */ UserData bMM;
    final /* synthetic */ PersonalChatActivity cdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalChatActivity personalChatActivity, UserData userData) {
        this.cdg = personalChatActivity;
        this.bMM = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.abO().aK(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bMM.getUserId())));
    }
}
