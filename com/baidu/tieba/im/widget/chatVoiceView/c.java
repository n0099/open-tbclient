package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.db.q;
import com.baidu.tieba.im.message.g;
import java.util.LinkedList;
/* loaded from: classes.dex */
class c extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ ChatVoiceView a;
    private final /* synthetic */ g c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChatVoiceView chatVoiceView, g gVar, LinkedList linkedList) {
        this.a = chatVoiceView;
        this.c = gVar;
        this.d = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(q.a().a(this.c.m(), this.c.c(), this.d, false));
    }
}
