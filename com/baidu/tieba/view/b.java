package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView fZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.fZS = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.fZS.HG;
        if (i > 0) {
            view = this.fZS.HF;
            view2 = this.fZS.HF;
            int width = view2.getWidth();
            i2 = this.fZS.HG;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.fZS.invalidate();
        }
    }
}
