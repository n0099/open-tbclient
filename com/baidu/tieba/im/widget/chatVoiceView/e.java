package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends s<Boolean> {
    final /* synthetic */ ChatVoiceView dfO;
    private final /* synthetic */ PersonalChatMessage dfP;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.dfO = chatVoiceView;
        this.dfP = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(l.aqw().a(com.baidu.tieba.im.util.h.n(this.dfP), this.val$list, false));
    }
}
