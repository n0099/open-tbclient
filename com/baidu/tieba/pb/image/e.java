package com.baidu.tieba.pb.image;

import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tieba.view.KeyboardLayout;
/* loaded from: classes.dex */
final class e implements Runnable {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EmotionTabHost emotionTabHost;
        KeyboardLayout keyboardLayout;
        com.baidu.tieba.view.u uVar;
        EmotionTabHost emotionTabHost2;
        emotionTabHost = this.a.o;
        if (emotionTabHost.getVisibility() != 0) {
            emotionTabHost2 = this.a.o;
            emotionTabHost2.setVisibility(0);
        }
        keyboardLayout = this.a.s;
        uVar = this.a.U;
        keyboardLayout.setOnkbdStateListener(uVar);
    }
}
