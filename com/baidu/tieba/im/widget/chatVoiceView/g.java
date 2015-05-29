package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.util.i;
import java.util.LinkedList;
/* loaded from: classes.dex */
class g extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ ChatVoiceView brr;
    private final /* synthetic */ OfficialChatMessage brt;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.brr = chatVoiceView;
        this.brt = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(m.RA().a(i.o(this.brt), this.val$list, false));
    }
}
