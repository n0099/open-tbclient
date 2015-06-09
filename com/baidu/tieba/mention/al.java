package com.baidu.tieba.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements AbsListView.OnScrollListener {
    final /* synthetic */ ai bGF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ai aiVar) {
        this.bGF = aiVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        if (i != 0) {
            z = this.bGF.bGE;
            if (!z) {
                this.bGF.bGE = true;
                this.bGF.Kl();
            }
        }
    }
}
