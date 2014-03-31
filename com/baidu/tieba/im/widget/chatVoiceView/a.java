package com.baidu.tieba.im.widget.chatVoiceView;

import com.baidu.tieba.im.m;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends m<Boolean> {
    final /* synthetic */ ChatVoiceView b;
    private final /* synthetic */ com.baidu.tieba.im.message.a.b c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatVoiceView chatVoiceView, com.baidu.tieba.im.message.a.b bVar, LinkedList linkedList) {
        this.b = chatVoiceView;
        this.c = bVar;
        this.d = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().a(this.c.i(), this.d, false));
    }
}
