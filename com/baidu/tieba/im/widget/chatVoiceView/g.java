package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.m;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends m<Boolean> {
    final /* synthetic */ ChatVoiceView b;
    private final /* synthetic */ com.baidu.tieba.im.message.a.e c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatVoiceView chatVoiceView, com.baidu.tieba.im.message.a.e eVar, LinkedList linkedList) {
        this.b = chatVoiceView;
        this.c = eVar;
        this.d = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.d().a(this.c.x(), this.c.l(), this.d, false));
    }
}
