package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class i extends com.baidu.tbadk.util.p<Boolean> {
    private final /* synthetic */ UserData cbd;
    final /* synthetic */ PersonalChatActivity csk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalChatActivity personalChatActivity, UserData userData) {
        this.csk = personalChatActivity;
        this.cbd = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.ain().bc(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.cbd.getUserId())));
    }
}
