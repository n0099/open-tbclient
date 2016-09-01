package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends t<Boolean> {
    private final /* synthetic */ PersonalChatMessage dmA;
    final /* synthetic */ ChatVoiceView dmz;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.dmz = chatVoiceView;
        this.dmA = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(l.asu().a(com.baidu.tieba.im.util.h.p(this.dmA), this.val$list, false));
    }
}
