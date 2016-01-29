package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class g extends m<Boolean> {
    final /* synthetic */ ChatVoiceView chd;
    private final /* synthetic */ OfficialChatMessage chf;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.chd = chatVoiceView;
        this.chf = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(k.abh().a(com.baidu.tieba.im.util.h.o(this.chf), this.val$list, false));
    }
}
