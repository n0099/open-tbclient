package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ ChatVoiceView csF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChatVoiceView chatVoiceView) {
        this.csF = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        ImageView imageView;
        imageView = this.csF.csC;
        imageView.setVisibility(8);
    }
}
