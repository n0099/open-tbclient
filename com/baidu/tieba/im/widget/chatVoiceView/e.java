package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.i;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ ChatVoiceView bov;
    private final /* synthetic */ PersonalChatMessage bow;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.bov = chatVoiceView;
        this.bow = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(n.PZ().a(i.o(this.bow), this.val$list, false));
    }
}
