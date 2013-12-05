package com.baidu.tieba.pb;

import com.baidu.tieba.editortool.FaceView;
import com.baidu.tieba.view.KeyboardLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ImagePbActivity imagePbActivity) {
        this.f2149a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        FaceView faceView;
        KeyboardLayout keyboardLayout;
        com.baidu.tieba.view.aq aqVar;
        FaceView faceView2;
        faceView = this.f2149a.o;
        if (faceView.getVisibility() != 0) {
            faceView2 = this.f2149a.o;
            faceView2.setVisibility(0);
        }
        keyboardLayout = this.f2149a.s;
        aqVar = this.f2149a.T;
        keyboardLayout.setOnkbdStateListener(aqVar);
    }
}
