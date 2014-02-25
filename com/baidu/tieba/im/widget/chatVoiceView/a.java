package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.message.g;
import java.util.LinkedList;
/* loaded from: classes.dex */
class a extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ ChatVoiceView a;
    private final /* synthetic */ g c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatVoiceView chatVoiceView, g gVar, LinkedList linkedList) {
        this.a = chatVoiceView;
        this.c = gVar;
        this.d = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.db.b.a().a(this.c.u(), this.d, false));
    }
}
