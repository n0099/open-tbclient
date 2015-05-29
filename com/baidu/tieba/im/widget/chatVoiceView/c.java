package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.util.i;
import java.util.LinkedList;
/* loaded from: classes.dex */
class c extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ ChatVoiceView brr;
    private final /* synthetic */ CommonGroupChatMessage val$groupMsg;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChatVoiceView chatVoiceView, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.brr = chatVoiceView;
        this.val$groupMsg = commonGroupChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(n.RB().a(i.o(this.val$groupMsg), this.val$list, false));
    }
}
