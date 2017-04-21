package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView fLF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.fLF = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.fLF.HI;
        if (i > 0) {
            view = this.fLF.HH;
            view2 = this.fLF.HH;
            int width = view2.getWidth();
            i2 = this.fLF.HI;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.fLF.invalidate();
        }
    }
}
