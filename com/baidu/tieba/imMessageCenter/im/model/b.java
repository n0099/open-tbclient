package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class b extends t<Boolean> {
    final /* synthetic */ PersonalMsglistModel dfF;
    private final /* synthetic */ ChatMessage val$msg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PersonalMsglistModel personalMsglistModel, ChatMessage chatMessage) {
        this.dfF = personalMsglistModel;
        this.val$msg = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        UserData userData;
        l anF = l.anF();
        userData = this.dfF.mUser;
        return Boolean.valueOf(anF.bc(String.valueOf(userData.getUserId()), String.valueOf(this.val$msg.getMsgId())));
    }
}
