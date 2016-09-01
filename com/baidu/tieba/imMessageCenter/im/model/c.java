package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class c extends t<Boolean> {
    final /* synthetic */ PersonalMsglistModel drm;
    private final /* synthetic */ ChatMessage val$msg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalMsglistModel personalMsglistModel, ChatMessage chatMessage) {
        this.drm = personalMsglistModel;
        this.val$msg = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        UserData userData;
        l asu = l.asu();
        userData = this.drm.mUser;
        return Boolean.valueOf(asu.bc(String.valueOf(userData.getUserId()), String.valueOf(this.val$msg.getMsgId())));
    }
}
