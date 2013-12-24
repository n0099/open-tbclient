package com.baidu.tieba.pb;

import com.baidu.tieba.editortool.FaceView;
import com.baidu.tieba.view.KeyboardLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        FaceView faceView;
        KeyboardLayout keyboardLayout;
        com.baidu.tieba.view.aq aqVar;
        FaceView faceView2;
        faceView = this.a.o;
        if (faceView.getVisibility() != 0) {
            faceView2 = this.a.o;
            faceView2.setVisibility(0);
        }
        keyboardLayout = this.a.s;
        aqVar = this.a.T;
        keyboardLayout.setOnkbdStateListener(aqVar);
    }
}
