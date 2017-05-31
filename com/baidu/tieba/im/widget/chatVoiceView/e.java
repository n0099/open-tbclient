package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends v<Boolean> {
    final /* synthetic */ ChatVoiceView dit;
    private final /* synthetic */ PersonalChatMessage diu;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.dit = chatVoiceView;
        this.diu = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(m.aoD().a(com.baidu.tieba.im.util.h.p(this.diu), this.val$list, false));
    }
}
