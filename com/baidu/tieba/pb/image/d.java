package com.baidu.tieba.pb.image;

import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tieba.view.KeyboardLayout;
/* loaded from: classes.dex */
final class d implements Runnable {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EmotionTabHost emotionTabHost;
        KeyboardLayout keyboardLayout;
        com.baidu.tieba.view.s sVar;
        EmotionTabHost emotionTabHost2;
        emotionTabHost = this.a.n;
        if (emotionTabHost.getVisibility() != 0) {
            emotionTabHost2 = this.a.n;
            emotionTabHost2.setVisibility(0);
        }
        keyboardLayout = this.a.r;
        sVar = this.a.T;
        keyboardLayout.setOnkbdStateListener(sVar);
    }
}
