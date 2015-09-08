package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ ChatVoiceView bFN;
    private final /* synthetic */ PersonalChatMessage bFO;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.bFN = chatVoiceView;
        this.bFO = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(l.Tm().a(com.baidu.tieba.im.util.h.o(this.bFO), this.val$list, false));
    }
}
