package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends v<Boolean> {
    final /* synthetic */ ChatVoiceView dcX;
    private final /* synthetic */ PersonalChatMessage dcY;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.dcX = chatVoiceView;
        this.dcY = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(m.anD().a(com.baidu.tieba.im.util.h.p(this.dcY), this.val$list, false));
    }
}
