package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class i extends com.baidu.tbadk.util.l<Boolean> {
    final /* synthetic */ PersonalChatActivity bKb;
    private final /* synthetic */ UserData btZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalChatActivity personalChatActivity, UserData userData) {
        this.bKb = personalChatActivity;
        this.btZ = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.XA().aK(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.btZ.getUserId())));
    }
}
