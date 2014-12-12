package com.baidu.tieba.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements AbsListView.OnScrollListener {
    final /* synthetic */ af bsE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(af afVar) {
        this.bsE = afVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        if (i != 0) {
            z = this.bsE.bsD;
            if (!z) {
                this.bsE.bsD = true;
                this.bsE.Fj();
            }
        }
    }
}
