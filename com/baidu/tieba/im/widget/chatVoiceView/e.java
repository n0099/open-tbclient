package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.db.o;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.i;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ PersonalChatMessage bpA;
    final /* synthetic */ ChatVoiceView bpz;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.bpz = chatVoiceView;
        this.bpA = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(o.MO().a(i.n(this.bpA), this.val$list, false));
    }
}
