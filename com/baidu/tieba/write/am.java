package com.baidu.tieba.write;

import android.widget.GridView;
/* loaded from: classes.dex */
class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2634a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.f2634a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        GridView gridView2;
        gridView = this.f2634a.u;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.f2634a.u;
            gridView2.setVisibility(0);
        }
    }
}
