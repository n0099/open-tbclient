package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ ChatVoiceView cXU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChatVoiceView chatVoiceView) {
        this.cXU = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        ImageView imageView;
        imageView = this.cXU.cXR;
        imageView.setVisibility(8);
    }
}
