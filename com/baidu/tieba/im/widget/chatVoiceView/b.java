package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.util.f<Boolean> {
    final /* synthetic */ ChatVoiceView dgE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChatVoiceView chatVoiceView) {
        this.dgE = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        ImageView imageView;
        imageView = this.dgE.dgB;
        imageView.setVisibility(8);
    }
}
