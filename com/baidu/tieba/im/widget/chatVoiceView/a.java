package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends l<Boolean> {
    final /* synthetic */ ChatVoiceView bJd;
    private final /* synthetic */ CommonGroupChatMessage val$groupMsg;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatVoiceView chatVoiceView, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.bJd = chatVoiceView;
        this.val$groupMsg = commonGroupChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.TB().a(this.val$groupMsg.getGroupId(), this.val$list, false));
    }
}
