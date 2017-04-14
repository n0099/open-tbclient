package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView fJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.fJj = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.fJj.HG;
        if (i > 0) {
            view = this.fJj.HF;
            view2 = this.fJj.HF;
            int width = view2.getWidth();
            i2 = this.fJj.HG;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.fJj.invalidate();
        }
    }
}
