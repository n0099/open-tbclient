package com.baidu.tieba.pb;

import android.widget.GridView;
import com.baidu.tieba.view.KeyboardLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ImagePbActivity imagePbActivity) {
        this.f2141a = imagePbActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        KeyboardLayout keyboardLayout;
        com.baidu.tieba.view.ap apVar;
        GridView gridView2;
        gridView = this.f2141a.p;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.f2141a.p;
            gridView2.setVisibility(0);
        }
        keyboardLayout = this.f2141a.t;
        apVar = this.f2141a.T;
        keyboardLayout.setOnkbdStateListener(apVar);
    }
}
