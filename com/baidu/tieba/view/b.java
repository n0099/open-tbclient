package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ BdExpandListView fud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdExpandListView bdExpandListView) {
        this.fud = bdExpandListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        View view;
        View view2;
        int i2;
        i = this.fud.Bh;
        if (i > 0) {
            view = this.fud.Bg;
            view2 = this.fud.Bg;
            int width = view2.getWidth();
            i2 = this.fud.Bh;
            view.setLayoutParams(new AbsListView.LayoutParams(width, i2));
            this.fud.invalidate();
        }
    }
}
