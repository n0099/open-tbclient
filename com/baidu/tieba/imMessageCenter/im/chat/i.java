package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class i extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ UserData bbU;
    final /* synthetic */ PersonalChatActivity brV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonalChatActivity personalChatActivity, UserData userData) {
        this.brV = personalChatActivity;
        this.bbU = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.UR().aK(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bbU.getUserId())));
    }
}
