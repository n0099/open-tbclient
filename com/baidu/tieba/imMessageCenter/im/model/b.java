package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.p;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class b extends p<Boolean> {
    final /* synthetic */ PersonalMsglistModel cwt;
    private final /* synthetic */ ChatMessage val$msg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PersonalMsglistModel personalMsglistModel, ChatMessage chatMessage) {
        this.cwt = personalMsglistModel;
        this.val$msg = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        UserData userData;
        l aeE = l.aeE();
        userData = this.cwt.mUser;
        return Boolean.valueOf(aeE.aX(String.valueOf(userData.getUserId()), String.valueOf(this.val$msg.getMsgId())));
    }
}
