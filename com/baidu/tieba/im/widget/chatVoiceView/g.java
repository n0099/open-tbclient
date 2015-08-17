package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ ChatVoiceView bFg;
    private final /* synthetic */ OfficialChatMessage bFi;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.bFg = chatVoiceView;
        this.bFi = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(k.Tj().a(com.baidu.tieba.im.util.h.o(this.bFi), this.val$list, false));
    }
}
