package com.baidu.tieba.pb;

import android.widget.GridView;
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
        GridView gridView;
        KeyboardLayout keyboardLayout;
        com.baidu.tieba.view.aa aaVar;
        GridView gridView2;
        gridView = this.a.n;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.a.n;
            gridView2.setVisibility(0);
        }
        keyboardLayout = this.a.r;
        aaVar = this.a.R;
        keyboardLayout.setOnkbdStateListener(aaVar);
    }
}
