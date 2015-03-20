package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ ChatVoiceView bov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChatVoiceView chatVoiceView) {
        this.bov = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        ImageView imageView;
        imageView = this.bov.bos;
        imageView.setVisibility(8);
    }
}
