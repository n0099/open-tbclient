package com.baidu.tieba.recommendfrs;

import android.widget.AbsListView;
import com.baidu.tieba.card.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AbsListView.OnScrollListener {
    private int dDQ = -1;
    private int dDR = 0;
    private boolean dDS = false;
    final /* synthetic */ p dDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.dDT = pVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.dDT.dDx == null) {
            this.dDT.dDx = new com.baidu.tbadk.performanceLog.m();
            this.dDT.dDx.eZ(1005);
            this.dDT.dDx.pageType = 1;
        }
        this.dDT.dDx.FF();
        if (i == 0) {
            ax.Kc().Kd();
            if (this.dDS) {
                this.dDT.aFh();
            }
            this.dDS = false;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dDR > i) {
            this.dDS = true;
        }
        this.dDR = i;
        int i4 = (i + i2) - 1;
        if (!this.dDS && this.dDQ != i4) {
            this.dDQ = i4;
            this.dDT.nt(this.dDQ);
        }
        if (this.dDS && this.dDQ != i) {
            this.dDQ = i;
            this.dDT.nt(this.dDQ);
        }
    }
}
