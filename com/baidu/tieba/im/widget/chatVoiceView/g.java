package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.d.j;
import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class g extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ChatVoiceView a;
    private final /* synthetic */ OfficialChatMessage b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.a = chatVoiceView;
        this.b = officialChatMessage;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(n.c().a(j.a(this.b), this.c, false));
    }
}
