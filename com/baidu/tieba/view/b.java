package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView fVJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.fVJ = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.fVJ.Bj;
        if (i > 0) {
            view = this.fVJ.Bi;
            view2 = this.fVJ.Bi;
            int width = view2.getWidth();
            i2 = this.fVJ.Bj;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.fVJ.invalidate();
        }
    }
}
