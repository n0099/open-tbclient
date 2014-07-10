package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.db.o;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ChatVoiceView b;
    private final /* synthetic */ OfficialChatMessage c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.b = chatVoiceView;
        this.c = officialChatMessage;
        this.d = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(o.d().a(this.c.getUserId(), this.c.getToUserId(), this.d, false));
    }
}
