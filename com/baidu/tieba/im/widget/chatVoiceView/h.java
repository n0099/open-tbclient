package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.util.f<Boolean> {
    final /* synthetic */ ChatVoiceView dtF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChatVoiceView chatVoiceView) {
        this.dtF = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        ImageView imageView;
        imageView = this.dtF.dtC;
        imageView.setVisibility(8);
    }
}
