package com.baidu.tieba.pb;

import android.widget.GridView;
import com.baidu.tieba.view.KeyboardLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1537a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImagePbActivity imagePbActivity) {
        this.f1537a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        KeyboardLayout keyboardLayout;
        com.baidu.tieba.view.ar arVar;
        GridView gridView2;
        gridView = this.f1537a.p;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.f1537a.p;
            gridView2.setVisibility(0);
        }
        keyboardLayout = this.f1537a.t;
        arVar = this.f1537a.T;
        keyboardLayout.setOnkbdStateListener(arVar);
    }
}
