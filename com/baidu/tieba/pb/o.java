package com.baidu.tieba.pb;

import android.widget.GridView;
import com.baidu.tieba.view.KeyboardLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1286a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImagePbActivity imagePbActivity) {
        this.f1286a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        KeyboardLayout keyboardLayout;
        com.baidu.tieba.view.af afVar;
        GridView gridView2;
        gridView = this.f1286a.p;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.f1286a.p;
            gridView2.setVisibility(0);
        }
        keyboardLayout = this.f1286a.t;
        afVar = this.f1286a.T;
        keyboardLayout.setOnkbdStateListener(afVar);
    }
}
