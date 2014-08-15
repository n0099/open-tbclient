package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.d.j;
import com.baidu.tieba.im.db.o;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ChatVoiceView a;
    private final /* synthetic */ PersonalChatMessage b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.a = chatVoiceView;
        this.b = personalChatMessage;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(o.c().a(j.a(this.b), this.c, false));
    }
}
