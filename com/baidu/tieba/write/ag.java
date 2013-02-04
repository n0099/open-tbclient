package com.baidu.tieba.write;

import android.widget.GridView;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        GridView gridView2;
        gridView = this.a.p;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.a.p;
            gridView2.setVisibility(0);
        }
    }
}
