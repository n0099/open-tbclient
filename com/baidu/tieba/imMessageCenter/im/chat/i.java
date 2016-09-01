package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class i extends com.baidu.tbadk.util.t<Boolean> {
    private final /* synthetic */ UserData cVy;
    final /* synthetic */ PersonalChatActivity dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalChatActivity personalChatActivity, UserData userData) {
        this.dnc = personalChatActivity;
        this.cVy = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.awk().bi(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.cVy.getUserId())));
    }
}
