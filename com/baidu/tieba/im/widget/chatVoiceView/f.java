package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.util.d<Boolean> {
    final /* synthetic */ ChatVoiceView bYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ChatVoiceView chatVoiceView) {
        this.bYD = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        ImageView imageView;
        imageView = this.bYD.bYA;
        imageView.setVisibility(8);
    }
}
