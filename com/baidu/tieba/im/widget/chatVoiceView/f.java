package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ChatVoiceView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ChatVoiceView chatVoiceView) {
        this.a = chatVoiceView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        ImageView imageView;
        imageView = this.a.d;
        imageView.setVisibility(8);
    }
}
