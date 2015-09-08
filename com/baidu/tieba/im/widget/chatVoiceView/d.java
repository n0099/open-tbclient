package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ ChatVoiceView bFN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChatVoiceView chatVoiceView) {
        this.bFN = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        ImageView imageView;
        imageView = this.bFN.bFK;
        imageView.setVisibility(8);
    }
}
