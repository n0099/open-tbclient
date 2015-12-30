package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements AbsListView.OnScrollListener {
    final /* synthetic */ be cYp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(be beVar) {
        this.cYp = beVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        View view2;
        View view3;
        View view4;
        if (i == 0) {
            view3 = this.cYp.line;
            if (view3 != null) {
                view4 = this.cYp.line;
                view4.setVisibility(0);
                return;
            }
            return;
        }
        view = this.cYp.line;
        if (view != null) {
            view2 = this.cYp.line;
            view2.setVisibility(8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.cYp.aqM();
        this.cYp.aqN();
    }
}
