package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView fHA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.fHA = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.fHA.If;
        if (i > 0) {
            view = this.fHA.Ie;
            view2 = this.fHA.Ie;
            int width = view2.getWidth();
            i2 = this.fHA.If;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.fHA.invalidate();
        }
    }
}
