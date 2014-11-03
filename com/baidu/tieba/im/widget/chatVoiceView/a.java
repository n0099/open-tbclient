package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class a extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ChatVoiceView bkk;
    private final /* synthetic */ CommonGroupChatMessage val$groupMsg;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatVoiceView chatVoiceView, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.bkk = chatVoiceView;
        this.val$groupMsg = commonGroupChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.MA().a(this.val$groupMsg.getGroupId(), this.val$list, false));
    }
}
