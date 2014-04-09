package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.db.o;
import com.baidu.tieba.im.m;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends m<Boolean> {
    final /* synthetic */ ChatVoiceView b;
    private final /* synthetic */ com.baidu.tieba.im.message.a.f c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatVoiceView chatVoiceView, com.baidu.tieba.im.message.a.f fVar, LinkedList linkedList) {
        this.b = chatVoiceView;
        this.c = fVar;
        this.d = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(o.d().a(this.c.x(), this.c.l(), this.d, false));
    }
}
