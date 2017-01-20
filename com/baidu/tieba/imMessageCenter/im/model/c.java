package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class c extends s<Boolean> {
    final /* synthetic */ PersonalMsglistModel diz;
    private final /* synthetic */ ChatMessage val$msg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalMsglistModel personalMsglistModel, ChatMessage chatMessage) {
        this.diz = personalMsglistModel;
        this.val$msg = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        UserData userData;
        l aqw = l.aqw();
        userData = this.diz.mUser;
        return Boolean.valueOf(aqw.bf(String.valueOf(userData.getUserId()), String.valueOf(this.val$msg.getMsgId())));
    }
}
