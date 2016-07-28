package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends t<Boolean> {
    final /* synthetic */ ChatVoiceView daR;
    private final /* synthetic */ PersonalChatMessage daS;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.daR = chatVoiceView;
        this.daS = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(l.anF().a(com.baidu.tieba.im.util.h.p(this.daS), this.val$list, false));
    }
}
