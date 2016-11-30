package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView gfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.gfi = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.gfi.Bj;
        if (i > 0) {
            view = this.gfi.Bi;
            view2 = this.gfi.Bi;
            int width = view2.getWidth();
            i2 = this.gfi.Bj;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.gfi.invalidate();
        }
    }
}
