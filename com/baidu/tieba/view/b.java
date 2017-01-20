package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView fCZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.fCZ = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.fCZ.AS;
        if (i > 0) {
            view = this.fCZ.AR;
            view2 = this.fCZ.AR;
            int width = view2.getWidth();
            i2 = this.fCZ.AS;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.fCZ.invalidate();
        }
    }
}
