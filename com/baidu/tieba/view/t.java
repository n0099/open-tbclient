package com.baidu.tieba.view;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements AbsListView.OnScrollListener {
    final /* synthetic */ s fQQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.fQQ = sVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        z zVar;
        int i2;
        int i3;
        int i4;
        z zVar2;
        zVar = this.fQQ.fQJ;
        if (zVar != null) {
            zVar2 = this.fQQ.fQJ;
            zVar2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            i2 = this.fQQ.fQC;
            if (i2 > 2 && this.fQQ.eKX.getVisibility() != 0) {
                this.fQQ.adW();
            }
            if (this.fQQ.fQE != null) {
                i3 = this.fQQ.fQC;
                if (i3 <= 2 && this.fQQ.eKX.getVisibility() == 0) {
                    int top = this.fQQ.fQE.getTop();
                    i4 = this.fQQ.fQP;
                    if (top > i4) {
                        this.fQQ.aRw();
                    }
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        z zVar;
        boolean z;
        int i4;
        int i5;
        boolean z2;
        int i6;
        int i7;
        z zVar2;
        this.fQQ.Rw();
        this.fQQ.Rx();
        zVar = this.fQQ.fQJ;
        if (zVar != null) {
            zVar2 = this.fQQ.fQJ;
            zVar2.onScroll(absListView, i, i2, i3);
        }
        if (i == 0 && this.fQQ.mNavigationBar.getY() != 0.0f) {
            this.fQQ.mNavigationBar.setY(0.0f);
        }
        if (this.fQQ.fQE != null) {
            z2 = this.fQQ.fQK;
            if (!z2) {
                i6 = this.fQQ.fQC;
                if (i6 <= i) {
                    if (this.fQQ.fQE.getTop() <= this.fQQ.mNavigationBar.getHeight() && this.fQQ.fQE.getTop() > 0) {
                        this.fQQ.mNavigationBar.setY(this.fQQ.fQE.getTop() - this.fQQ.mNavigationBar.getHeight());
                    }
                    int top = this.fQQ.fQE.getTop();
                    i7 = this.fQQ.fQP;
                    if (top < i7) {
                        this.fQQ.adW();
                        this.fQQ.fQK = true;
                    }
                }
            }
        }
        if (this.fQQ.fQE != null) {
            z = this.fQQ.fQK;
            if (z) {
                i4 = this.fQQ.fQC;
                if (i4 >= i) {
                    int top2 = this.fQQ.fQE.getTop();
                    i5 = this.fQQ.fQP;
                    if (top2 > i5) {
                        this.fQQ.aRw();
                        this.fQQ.fQK = false;
                    }
                }
            }
        }
        this.fQQ.fQC = i;
    }
}
