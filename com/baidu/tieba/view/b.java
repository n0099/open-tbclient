package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView fQb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.fQb = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.fQb.HH;
        if (i > 0) {
            view = this.fQb.HG;
            view2 = this.fQb.HG;
            int width = view2.getWidth();
            i2 = this.fQb.HH;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.fQb.invalidate();
        }
    }
}
