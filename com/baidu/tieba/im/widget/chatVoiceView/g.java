package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends l<Boolean> {
    final /* synthetic */ ChatVoiceView bIS;
    private final /* synthetic */ OfficialChatMessage bIU;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.bIS = chatVoiceView;
        this.bIU = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(k.TT().a(com.baidu.tieba.im.util.h.o(this.bIU), this.val$list, false));
    }
}
