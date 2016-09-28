package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ ChatVoiceView dnW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChatVoiceView chatVoiceView) {
        this.dnW = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        ImageView imageView;
        imageView = this.dnW.dnT;
        imageView.setVisibility(8);
    }
}
