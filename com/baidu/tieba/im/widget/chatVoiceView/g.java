package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class g extends v<Boolean> {
    final /* synthetic */ ChatVoiceView dit;
    private final /* synthetic */ OfficialChatMessage div;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.dit = chatVoiceView;
        this.div = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(l.aoC().a(com.baidu.tieba.im.util.h.p(this.div), this.val$list, false));
    }
}
