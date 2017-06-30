package com.baidu.tieba.imMessageCenter.im.model;

import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
class c extends w<Boolean> {
    final /* synthetic */ PersonalMsglistModel dtb;
    private final /* synthetic */ ChatMessage val$msg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PersonalMsglistModel personalMsglistModel, ChatMessage chatMessage) {
        this.dtb = personalMsglistModel;
        this.val$msg = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        UserData userData;
        m aso = m.aso();
        userData = this.dtb.mUser;
        return Boolean.valueOf(aso.bf(String.valueOf(userData.getUserId()), String.valueOf(this.val$msg.getMsgId())));
    }
}
