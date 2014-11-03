package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.util.i;
import java.util.LinkedList;
/* loaded from: classes.dex */
class g extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ChatVoiceView bkk;
    private final /* synthetic */ OfficialChatMessage bkm;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.bkk = chatVoiceView;
        this.bkm = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(n.MT().a(i.o(this.bkm), this.val$list, false));
    }
}
