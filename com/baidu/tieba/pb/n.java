package com.baidu.tieba.pb;

import com.baidu.tieba.editortool.EmotionTabHost;
import com.baidu.tieba.view.KeyboardLayout;
/* loaded from: classes.dex */
final class n implements Runnable {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EmotionTabHost emotionTabHost;
        KeyboardLayout keyboardLayout;
        com.baidu.tieba.view.bo boVar;
        EmotionTabHost emotionTabHost2;
        emotionTabHost = this.a.o;
        if (emotionTabHost.getVisibility() != 0) {
            emotionTabHost2 = this.a.o;
            emotionTabHost2.setVisibility(0);
        }
        keyboardLayout = this.a.s;
        boVar = this.a.U;
        keyboardLayout.setOnkbdStateListener(boVar);
    }
}
