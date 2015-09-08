package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class i extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ PersonalChatActivity bGq;
    private final /* synthetic */ UserData bqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalChatActivity personalChatActivity, UserData userData) {
        this.bGq = personalChatActivity;
        this.bqn = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.WA().aM(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bqn.getUserId())));
    }
}
