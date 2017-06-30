package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.w;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class g extends w<Boolean> {
    final /* synthetic */ ChatVoiceView dqp;
    private final /* synthetic */ OfficialChatMessage dqr;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.dqp = chatVoiceView;
        this.dqr = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        return Boolean.valueOf(l.asn().a(com.baidu.tieba.im.util.h.p(this.dqr), this.val$list, false));
    }
}
