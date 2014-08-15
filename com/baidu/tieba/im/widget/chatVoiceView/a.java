package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class a extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ChatVoiceView a;
    private final /* synthetic */ CommonGroupChatMessage b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatVoiceView chatVoiceView, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.a = chatVoiceView;
        this.b = commonGroupChatMessage;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().a(this.b.getGroupId(), this.c, false));
    }
}
