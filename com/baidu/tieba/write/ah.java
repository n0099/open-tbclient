package com.baidu.tieba.write;

import android.widget.GridView;
/* loaded from: classes.dex */
class ah implements Runnable {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        GridView gridView2;
        gridView = this.a.r;
        if (gridView.getVisibility() != 0) {
            gridView2 = this.a.r;
            gridView2.setVisibility(0);
        }
    }
}
