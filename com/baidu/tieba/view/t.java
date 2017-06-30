package com.baidu.tieba.view;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements AbsListView.OnScrollListener {
    final /* synthetic */ s gaH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.gaH = sVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        z zVar;
        int i2;
        int i3;
        int i4;
        z zVar2;
        zVar = this.gaH.gaA;
        if (zVar != null) {
            zVar2 = this.gaH.gaA;
            zVar2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            i2 = this.gaH.gat;
            if (i2 > 2 && this.gaH.eUW.getVisibility() != 0) {
                this.gaH.ahK();
            }
            if (this.gaH.gav != null) {
                i3 = this.gaH.gat;
                if (i3 <= 2 && this.gaH.eUW.getVisibility() == 0) {
                    int top = this.gaH.gav.getTop();
                    i4 = this.gaH.gaG;
                    if (top > i4) {
                        this.gaH.aVE();
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
        this.gaH.Tl();
        this.gaH.Tm();
        zVar = this.gaH.gaA;
        if (zVar != null) {
            zVar2 = this.gaH.gaA;
            zVar2.onScroll(absListView, i, i2, i3);
        }
        if (i == 0 && this.gaH.mNavigationBar.getY() != 0.0f) {
            this.gaH.mNavigationBar.setY(0.0f);
        }
        if (this.gaH.gav != null) {
            z2 = this.gaH.gaB;
            if (!z2) {
                i6 = this.gaH.gat;
                if (i6 <= i) {
                    if (this.gaH.gav.getTop() <= this.gaH.mNavigationBar.getHeight() && this.gaH.gav.getTop() > 0) {
                        this.gaH.mNavigationBar.setY(this.gaH.gav.getTop() - this.gaH.mNavigationBar.getHeight());
                    }
                    int top = this.gaH.gav.getTop();
                    i7 = this.gaH.gaG;
                    if (top < i7) {
                        this.gaH.ahK();
                        this.gaH.gaB = true;
                    }
                }
            }
        }
        if (this.gaH.gav != null) {
            z = this.gaH.gaB;
            if (z) {
                i4 = this.gaH.gat;
                if (i4 >= i) {
                    int top2 = this.gaH.gav.getTop();
                    i5 = this.gaH.gaG;
                    if (top2 > i5) {
                        this.gaH.aVE();
                        this.gaH.gaB = false;
                    }
                }
            }
        }
        this.gaH.gat = i;
    }
}
