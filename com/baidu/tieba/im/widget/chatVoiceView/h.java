package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.util.d<Boolean> {
    final /* synthetic */ ChatVoiceView bJy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChatVoiceView chatVoiceView) {
        this.bJy = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        ImageView imageView;
        imageView = this.bJy.bJv;
        imageView.setVisibility(8);
    }
}
