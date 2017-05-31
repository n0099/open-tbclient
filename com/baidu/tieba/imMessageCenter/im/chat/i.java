package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.v;
/* loaded from: classes2.dex */
class i extends v<Boolean> {
    private final /* synthetic */ UserData cRp;
    final /* synthetic */ PersonalChatActivity diX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalChatActivity personalChatActivity, UserData userData) {
        this.diX = personalChatActivity;
        this.cRp = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.ass().be(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.cRp.getUserId())));
    }
}
