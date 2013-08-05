package com.baidu.tieba.write;

import android.widget.GridView;
/* loaded from: classes.dex */
class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1877a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.f1877a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        GridView gridView2;
        gridView = this.f1877a.r;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.f1877a.r;
            gridView2.setVisibility(0);
        }
    }
}
