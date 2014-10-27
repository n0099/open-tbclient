package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.db.o;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.i;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ChatVoiceView bjW;
    private final /* synthetic */ PersonalChatMessage bjX;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.bjW = chatVoiceView;
        this.bjX = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(o.MQ().a(i.o(this.bjX), this.val$list, false));
    }
}
