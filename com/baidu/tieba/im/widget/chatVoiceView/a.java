package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class a extends m<Boolean> {
    final /* synthetic */ ChatVoiceView bYD;
    private final /* synthetic */ CommonGroupChatMessage val$groupMsg;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatVoiceView chatVoiceView, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.bYD = chatVoiceView;
        this.val$groupMsg = commonGroupChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.Xc().a(this.val$groupMsg.getGroupId(), this.val$list, false));
    }
}
