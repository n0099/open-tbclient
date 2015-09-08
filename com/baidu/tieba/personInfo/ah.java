package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements AbsListView.OnScrollListener {
    final /* synthetic */ ag coZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.coZ = agVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        View view2;
        View view3;
        View view4;
        if (i == 0) {
            view3 = this.coZ.line;
            if (view3 != null) {
                view4 = this.coZ.line;
                view4.setVisibility(0);
                return;
            }
            return;
        }
        view = this.coZ.line;
        if (view != null) {
            view2 = this.coZ.line;
            view2.setVisibility(8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
