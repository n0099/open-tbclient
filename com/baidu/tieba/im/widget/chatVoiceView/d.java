package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.util.f<Boolean> {
    final /* synthetic */ ChatVoiceView dif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChatVoiceView chatVoiceView) {
        this.dif = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        ImageView imageView;
        imageView = this.dif.dic;
        imageView.setVisibility(8);
    }
}
