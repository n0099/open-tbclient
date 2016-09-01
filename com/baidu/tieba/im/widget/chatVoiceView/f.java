package com.baidu.tieba.im.widget.chatVoiceView;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ ChatVoiceView dmz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ChatVoiceView chatVoiceView) {
        this.dmz = chatVoiceView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        ImageView imageView;
        imageView = this.dmz.dmw;
        imageView.setVisibility(8);
    }
}
