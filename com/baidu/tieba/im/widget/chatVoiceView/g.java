package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class g extends s<Boolean> {
    final /* synthetic */ ChatVoiceView csF;
    private final /* synthetic */ OfficialChatMessage csH;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.csF = chatVoiceView;
        this.csH = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(k.aeC().a(com.baidu.tieba.im.util.h.o(this.csH), this.val$list, false));
    }
}
