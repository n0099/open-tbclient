package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends m<Boolean> {
    final /* synthetic */ ChatVoiceView bYD;
    private final /* synthetic */ PersonalChatMessage bYE;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.bYD = chatVoiceView;
        this.bYE = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(l.Xr().a(com.baidu.tieba.im.util.h.o(this.bYE), this.val$list, false));
    }
}
