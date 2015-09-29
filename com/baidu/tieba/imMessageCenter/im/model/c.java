package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class c extends l<Boolean> {
    final /* synthetic */ PersonalMsglistModel bNG;
    private final /* synthetic */ ChatMessage val$msg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalMsglistModel personalMsglistModel, ChatMessage chatMessage) {
        this.bNG = personalMsglistModel;
        this.val$msg = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        UserData userData;
        com.baidu.tieba.im.db.l TU = com.baidu.tieba.im.db.l.TU();
        userData = this.bNG.mUser;
        return Boolean.valueOf(TU.aF(String.valueOf(userData.getUserId()), String.valueOf(this.val$msg.getMsgId())));
    }
}
