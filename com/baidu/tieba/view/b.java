package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView fAR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.fAR = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.fAR.yt;
        if (i > 0) {
            view = this.fAR.ys;
            view2 = this.fAR.ys;
            int width = view2.getWidth();
            i2 = this.fAR.yt;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.fAR.invalidate();
        }
    }
}
