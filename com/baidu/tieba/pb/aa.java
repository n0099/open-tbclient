package com.baidu.tieba.pb;

import com.baidu.tieba.editortool.FaceView;
import com.baidu.tieba.view.KeyboardLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2042a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ImagePbActivity imagePbActivity) {
        this.f2042a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        FaceView faceView;
        KeyboardLayout keyboardLayout;
        com.baidu.tieba.view.ap apVar;
        FaceView faceView2;
        faceView = this.f2042a.o;
        if (faceView.getVisibility() != 0) {
            faceView2 = this.f2042a.o;
            faceView2.setVisibility(0);
        }
        keyboardLayout = this.f2042a.s;
        apVar = this.f2042a.T;
        keyboardLayout.setOnkbdStateListener(apVar);
    }
}
