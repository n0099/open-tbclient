package com.baidu.tieba.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements AbsListView.OnScrollListener {
    final /* synthetic */ ae bnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ae aeVar) {
        this.bnS = aeVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        if (i != 0) {
            z = this.bnS.bnR;
            if (!z) {
                this.bnS.bnR = true;
                this.bnS.EP();
            }
        }
    }
}
