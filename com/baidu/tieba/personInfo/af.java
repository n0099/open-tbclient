package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements AbsListView.OnScrollListener {
    final /* synthetic */ ae bLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.bLY = aeVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        View view2;
        View view3;
        View view4;
        if (i == 0) {
            view3 = this.bLY.line;
            if (view3 != null) {
                view4 = this.bLY.line;
                view4.setVisibility(0);
                return;
            }
            return;
        }
        view = this.bLY.line;
        if (view != null) {
            view2 = this.bLY.line;
            view2.setVisibility(8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
