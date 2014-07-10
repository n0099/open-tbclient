package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.db.p;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ChatVoiceView b;
    private final /* synthetic */ PersonalChatMessage c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.b = chatVoiceView;
        this.c = personalChatMessage;
        this.d = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(p.d().a(this.c.getUserId(), this.c.getToUserId(), this.d, false));
    }
}
