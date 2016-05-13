package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.s;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends s<Boolean> {
    final /* synthetic */ ChatVoiceView csF;
    private final /* synthetic */ PersonalChatMessage csG;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.csF = chatVoiceView;
        this.csG = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(l.aeF().a(com.baidu.tieba.im.util.h.o(this.csG), this.val$list, false));
    }
}
