package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements AbsListView.OnScrollListener {
    final /* synthetic */ bq eCH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bq bqVar) {
        this.eCH = bqVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        View view2;
        View view3;
        View view4;
        if (i == 0) {
            view3 = this.eCH.aHK;
            if (view3 != null) {
                view4 = this.eCH.aHK;
                view4.setVisibility(0);
                return;
            }
            return;
        }
        view = this.eCH.aHK;
        if (view != null) {
            view2 = this.eCH.aHK;
            view2.setVisibility(8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.eCH.aKW();
        this.eCH.aQf();
        this.eCH.aQe();
    }
}
