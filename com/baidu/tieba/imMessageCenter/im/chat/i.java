package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class i extends com.baidu.tbadk.util.s<Boolean> {
    private final /* synthetic */ UserData cRb;
    final /* synthetic */ PersonalChatActivity diK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalChatActivity personalChatActivity, UserData userData) {
        this.diK = personalChatActivity;
        this.cRb = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.atG().bd(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.cRb.getUserId())));
    }
}
