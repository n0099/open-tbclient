package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatVoiceView f1817a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatVoiceView chatVoiceView) {
        this.f1817a = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        ImageView imageView;
        imageView = this.f1817a.d;
        imageView.setVisibility(8);
    }
}
