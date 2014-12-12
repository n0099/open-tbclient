package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ ChatVoiceView bpz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChatVoiceView chatVoiceView) {
        this.bpz = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        ImageView imageView;
        imageView = this.bpz.bpw;
        imageView.setVisibility(8);
    }
}
