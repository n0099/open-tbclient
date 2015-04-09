package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class i extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ UserData aZm;
    final /* synthetic */ PersonalChatActivity bpo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalChatActivity personalChatActivity, UserData userData) {
        this.bpo = personalChatActivity;
        this.aZm = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.TD().aF(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aZm.getUserId())));
    }
}
