package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class b extends s<Boolean> {
    final /* synthetic */ PersonalMsglistModel dlH;
    private final /* synthetic */ ChatMessage val$msg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PersonalMsglistModel personalMsglistModel, ChatMessage chatMessage) {
        this.dlH = personalMsglistModel;
        this.val$msg = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        UserData userData;
        m aqK = m.aqK();
        userData = this.dlH.mUser;
        return Boolean.valueOf(aqK.bb(String.valueOf(userData.getUserId()), String.valueOf(this.val$msg.getMsgId())));
    }
}
