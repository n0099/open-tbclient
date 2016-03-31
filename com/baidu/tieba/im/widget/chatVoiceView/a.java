package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.p;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class a extends p<Boolean> {
    final /* synthetic */ ChatVoiceView crI;
    private final /* synthetic */ CommonGroupChatMessage val$groupMsg;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatVoiceView chatVoiceView, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.crI = chatVoiceView;
        this.val$groupMsg = commonGroupChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.aep().a(this.val$groupMsg.getGroupId(), this.val$list, false));
    }
}
