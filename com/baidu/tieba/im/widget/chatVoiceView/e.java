package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends s<Boolean> {
    final /* synthetic */ ChatVoiceView diV;
    private final /* synthetic */ PersonalChatMessage diW;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.diV = chatVoiceView;
        this.diW = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(m.aqK().a(com.baidu.tieba.im.util.h.p(this.diW), this.val$list, false));
    }
}
