package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class g extends t<Boolean> {
    private final /* synthetic */ OfficialChatMessage dmB;
    final /* synthetic */ ChatVoiceView dmz;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.dmz = chatVoiceView;
        this.dmB = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(k.ast().a(com.baidu.tieba.im.util.h.p(this.dmB), this.val$list, false));
    }
}
