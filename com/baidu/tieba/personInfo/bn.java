package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements AbsListView.OnScrollListener {
    final /* synthetic */ bi dEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bi biVar) {
        this.dEC = biVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        View view2;
        View view3;
        BdListView.e eVar;
        View view4;
        if (i == 0) {
            view3 = this.dEC.aKi;
            if (view3 != null) {
                view4 = this.dEC.aKi;
                view4.setVisibility(0);
            }
            if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getChildCount() > 0) {
                eVar = this.dEC.IL;
                eVar.nm();
                return;
            }
            return;
        }
        view = this.dEC.aKi;
        if (view != null) {
            view2 = this.dEC.aKi;
            view2.setVisibility(8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.dEC.aDH();
        this.dEC.aDI();
    }
}
