package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends s<Boolean> {
    final /* synthetic */ ChatVoiceView dgE;
    private final /* synthetic */ OfficialChatMessage dgG;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.dgE = chatVoiceView;
        this.dgG = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(l.apI().a(com.baidu.tieba.im.util.h.n(this.dgG), this.val$list, false));
    }
}
