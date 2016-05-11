package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements AbsListView.OnScrollListener {
    final /* synthetic */ bj dHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bj bjVar) {
        this.dHR = bjVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        View view2;
        View view3;
        BdListView.e eVar;
        View view4;
        if (i == 0) {
            view3 = this.dHR.aGr;
            if (view3 != null) {
                view4 = this.dHR.aGr;
                view4.setVisibility(0);
            }
            if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getChildCount() > 0) {
                eVar = this.dHR.zc;
                eVar.jA();
                return;
            }
            return;
        }
        view = this.dHR.aGr;
        if (view != null) {
            view2 = this.dHR.aGr;
            view2.setVisibility(8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.dHR.aEe();
        this.dHR.aEf();
        this.dHR.aEd();
    }
}
