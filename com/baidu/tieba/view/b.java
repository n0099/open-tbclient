package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView fNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.fNP = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.fNP.yU;
        if (i > 0) {
            view = this.fNP.yT;
            view2 = this.fNP.yT;
            int width = view2.getWidth();
            i2 = this.fNP.yU;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.fNP.invalidate();
        }
    }
}
