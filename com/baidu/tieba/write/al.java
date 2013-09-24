package com.baidu.tieba.write;

import android.widget.GridView;
/* loaded from: classes.dex */
class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2089a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.f2089a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        GridView gridView2;
        gridView = this.f2089a.u;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.f2089a.u;
            gridView2.setVisibility(0);
        }
    }
}
