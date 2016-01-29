package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends m<Boolean> {
    final /* synthetic */ ChatVoiceView chd;
    private final /* synthetic */ PersonalChatMessage che;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.chd = chatVoiceView;
        this.che = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(l.abi().a(com.baidu.tieba.im.util.h.o(this.che), this.val$list, false));
    }
}
