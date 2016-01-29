package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements AbsListView.OnScrollListener {
    final /* synthetic */ bi dkc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bi biVar) {
        this.dkc = biVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        View view2;
        View view3;
        View view4;
        if (i == 0) {
            view3 = this.dkc.aHm;
            if (view3 != null) {
                view4 = this.dkc.aHm;
                view4.setVisibility(0);
                return;
            }
            return;
        }
        view = this.dkc.aHm;
        if (view != null) {
            view2 = this.dkc.aHm;
            view2.setVisibility(8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.dkc.awc();
        this.dkc.awd();
    }
}
