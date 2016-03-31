package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.p;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class g extends p<Boolean> {
    final /* synthetic */ ChatVoiceView crI;
    private final /* synthetic */ OfficialChatMessage crK;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.crI = chatVoiceView;
        this.crK = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        return Boolean.valueOf(k.aeD().a(com.baidu.tieba.im.util.h.o(this.crK), this.val$list, false));
    }
}
