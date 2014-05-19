package com.baidu.tieba.pb.image;

import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tbadk.widget.KeyboardLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EmotionTabHost emotionTabHost;
        KeyboardLayout keyboardLayout;
        com.baidu.tbadk.widget.j jVar;
        EmotionTabHost emotionTabHost2;
        emotionTabHost = this.a.n;
        if (emotionTabHost.getVisibility() != 0) {
            emotionTabHost2 = this.a.n;
            emotionTabHost2.setVisibility(0);
        }
        keyboardLayout = this.a.r;
        jVar = this.a.T;
        keyboardLayout.setOnkbdStateListener(jVar);
    }
}
