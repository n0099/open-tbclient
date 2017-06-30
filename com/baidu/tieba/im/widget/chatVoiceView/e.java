package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.w;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends w<Boolean> {
    final /* synthetic */ ChatVoiceView dqp;
    private final /* synthetic */ PersonalChatMessage dqq;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.dqp = chatVoiceView;
        this.dqq = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        return Boolean.valueOf(m.aso().a(com.baidu.tieba.im.util.h.p(this.dqq), this.val$list, false));
    }
}
