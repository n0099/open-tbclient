package com.baidu.tieba.pb;

import com.baidu.tieba.editortool.EmotionTabHost;
import com.baidu.tieba.view.KeyboardLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
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
