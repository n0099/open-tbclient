package com.baidu.tieba.pb;

import android.widget.GridView;
import com.baidu.tieba.view.KeyboardLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        KeyboardLayout keyboardLayout;
        com.baidu.tieba.view.af afVar;
        GridView gridView2;
        gridView = this.a.p;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.a.p;
            gridView2.setVisibility(0);
        }
        keyboardLayout = this.a.t;
        afVar = this.a.T;
        keyboardLayout.setOnkbdStateListener(afVar);
    }
}
