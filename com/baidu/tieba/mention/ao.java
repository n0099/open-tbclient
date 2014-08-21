package com.baidu.tieba.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements AbsListView.OnScrollListener {
    final /* synthetic */ al a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.a = alVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0) {
            this.a.i();
        }
    }
}
