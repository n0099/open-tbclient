package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.message.g;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class a extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ChatVoiceView a;
    private final /* synthetic */ g c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatVoiceView chatVoiceView, g gVar, LinkedList linkedList) {
        this.a = chatVoiceView;
        this.c = gVar;
        this.d = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.b.a().a(this.c.u(), this.d, false));
    }
}
