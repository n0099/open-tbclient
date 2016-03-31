package com.baidu.tieba.recommendfrs;

import android.widget.AbsListView;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements AbsListView.OnScrollListener {
    private int dVI = -1;
    private int dVJ = 0;
    private boolean dVK = false;
    final /* synthetic */ q dVL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.dVL = qVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.dVL.dVo == null) {
            this.dVL.dVo = new com.baidu.tbadk.performanceLog.m();
            this.dVL.dVo.fh(1005);
            this.dVL.dVo.pageType = 1;
        }
        this.dVL.dVo.GB();
        if (i == 0) {
            cf.Lx().cc(true);
            if (this.dVK) {
                this.dVL.aLY();
            }
            this.dVK = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dVJ > i) {
            this.dVK = true;
        }
        this.dVJ = i;
        int i4 = (i + i2) - 1;
        if (!this.dVK && this.dVI != i4) {
            this.dVI = i4;
            this.dVL.oy(this.dVI);
        }
        if (this.dVK && this.dVI != i) {
            this.dVI = i;
            this.dVL.oy(this.dVI);
        }
    }
}
