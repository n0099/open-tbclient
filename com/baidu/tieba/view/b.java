package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView eWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.eWe = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.eWe.yr;
        if (i > 0) {
            view = this.eWe.yq;
            view2 = this.eWe.yq;
            int width = view2.getWidth();
            i2 = this.eWe.yr;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.eWe.invalidate();
        }
    }
}
