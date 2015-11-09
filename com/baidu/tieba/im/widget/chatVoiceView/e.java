package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends l<Boolean> {
    final /* synthetic */ ChatVoiceView bJy;
    private final /* synthetic */ PersonalChatMessage bJz;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.bJy = chatVoiceView;
        this.bJz = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.Ul().a(com.baidu.tieba.im.util.h.o(this.bJz), this.val$list, false));
    }
}
