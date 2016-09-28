package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class g extends t<Boolean> {
    final /* synthetic */ ChatVoiceView dnW;
    private final /* synthetic */ OfficialChatMessage dnY;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.dnW = chatVoiceView;
        this.dnY = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(k.asS().a(com.baidu.tieba.im.util.h.p(this.dnY), this.val$list, false));
    }
}
