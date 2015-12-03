package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class i extends com.baidu.tbadk.util.m<Boolean> {
    private final /* synthetic */ UserData bJe;
    final /* synthetic */ PersonalChatActivity bZg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalChatActivity personalChatActivity, UserData userData) {
        this.bZg = personalChatActivity;
        this.bJe = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.aaG().aP(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bJe.getUserId())));
    }
}
