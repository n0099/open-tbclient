package com.baidu.tieba.personInfo;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements AbsListView.OnScrollListener {
    final /* synthetic */ bs eqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bs bsVar) {
        this.eqW = bsVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        View view;
        View view2;
        View view3;
        BdListView.e eVar;
        View view4;
        if (i == 0) {
            view3 = this.eqW.aGT;
            if (view3 != null) {
                view4 = this.eqW.aGT;
                view4.setVisibility(0);
            }
            if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getChildCount() > 0) {
                eVar = this.eqW.zb;
                eVar.jD();
                return;
            }
            return;
        }
        view = this.eqW.aGT;
        if (view != null) {
            view2 = this.eqW.aGT;
            view2.setVisibility(8);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.eqW.aHM();
        this.eqW.aNc();
        this.eqW.aNb();
    }
}
