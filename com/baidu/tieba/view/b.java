package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView fXO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.fXO = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.fXO.Bj;
        if (i > 0) {
            view = this.fXO.Bi;
            view2 = this.fXO.Bi;
            int width = view2.getWidth();
            i2 = this.fXO.Bj;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.fXO.invalidate();
        }
    }
}
