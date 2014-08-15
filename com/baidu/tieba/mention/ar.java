package com.baidu.tieba.mention;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements AbsListView.OnScrollListener {
    final /* synthetic */ an a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(an anVar) {
        this.a = anVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0) {
            this.a.h();
        }
    }
}
