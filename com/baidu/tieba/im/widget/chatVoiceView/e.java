package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.p;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends p<Boolean> {
    final /* synthetic */ ChatVoiceView crI;
    private final /* synthetic */ PersonalChatMessage crJ;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.crI = chatVoiceView;
        this.crJ = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        return Boolean.valueOf(l.aeE().a(com.baidu.tieba.im.util.h.o(this.crJ), this.val$list, false));
    }
}
