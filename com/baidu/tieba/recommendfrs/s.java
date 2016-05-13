package com.baidu.tieba.recommendfrs;

import android.widget.AbsListView;
import com.baidu.tbadk.core.view.at;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements AbsListView.OnScrollListener {
    private int dYJ = -1;
    private int dYK = 0;
    private boolean dYL = false;
    final /* synthetic */ r dYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.dYM = rVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.dYM.dYi == null) {
            this.dYM.dYi = new com.baidu.tbadk.performanceLog.m();
            this.dYM.dYi.eL(1005);
            this.dYM.dYi.pageType = 1;
        }
        if (this.dYM.dYj != null) {
            this.dYM.dYj.onScrollStateChanged(absListView, i);
        }
        this.dYM.dYi.Eu();
        at.vE().aK(i == 0);
        if (i == 0) {
            bx.Ki().ci(true);
            if (this.dYL) {
                this.dYM.aMg();
            }
            this.dYL = false;
            this.dYM.Rm();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dYK > i) {
            this.dYL = true;
        }
        if (this.dYM.dYj != null) {
            this.dYM.dYj.a(absListView, this.dYK, i, i2, i3);
        }
        this.dYK = i;
        int i4 = (i + i2) - 1;
        if (!this.dYL && this.dYJ != i4) {
            this.dYJ = i4;
            this.dYM.op(this.dYJ);
        }
        if (this.dYL && this.dYJ != i) {
            this.dYJ = i;
            this.dYM.op(this.dYJ);
        }
    }
}
