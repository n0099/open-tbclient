package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
class c extends v<Boolean> {
    final /* synthetic */ PersonalMsglistModel dfL;
    private final /* synthetic */ ChatMessage val$msg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalMsglistModel personalMsglistModel, ChatMessage chatMessage) {
        this.dfL = personalMsglistModel;
        this.val$msg = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        UserData userData;
        m anD = m.anD();
        userData = this.dfL.mUser;
        return Boolean.valueOf(anD.ba(String.valueOf(userData.getUserId()), String.valueOf(this.val$msg.getMsgId())));
    }
}
