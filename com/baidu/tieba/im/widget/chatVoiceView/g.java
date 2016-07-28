package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class g extends t<Boolean> {
    final /* synthetic */ ChatVoiceView daR;
    private final /* synthetic */ OfficialChatMessage daT;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.daR = chatVoiceView;
        this.daT = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(k.anE().a(com.baidu.tieba.im.util.h.p(this.daT), this.val$list, false));
    }
}
