package com.baidu.tieba.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements AbsListView.OnScrollListener {
    final /* synthetic */ af bub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(af afVar) {
        this.bub = afVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        if (i != 0) {
            z = this.bub.bua;
            if (!z) {
                this.bub.bua = true;
                this.bub.FH();
            }
        }
    }
}
