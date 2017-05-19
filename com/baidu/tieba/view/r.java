package com.baidu.tieba.view;

import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements AbsListView.OnScrollListener {
    final /* synthetic */ q fIZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.fIZ = qVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        y yVar;
        int i2;
        int i3;
        int i4;
        y yVar2;
        yVar = this.fIZ.fIS;
        if (yVar != null) {
            yVar2 = this.fIZ.fIS;
            yVar2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            i2 = this.fIZ.fIJ;
            if (i2 > 2 && this.fIZ.fIP.getVisibility() != 0) {
                this.fIZ.acT();
            }
            i3 = this.fIZ.fIJ;
            if (i3 <= 2 && this.fIZ.fIP.getVisibility() == 0) {
                int top = this.fIZ.fIM.getTop();
                i4 = this.fIZ.fIY;
                if (top > i4) {
                    this.fIZ.aQf();
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        y yVar;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        y yVar2;
        this.fIZ.Rk();
        this.fIZ.Rl();
        yVar = this.fIZ.fIS;
        if (yVar != null) {
            yVar2 = this.fIZ.fIS;
            yVar2.onScroll(absListView, i, i2, i3);
        }
        if (i == 0 && this.fIZ.mNavigationBar.getY() != 0.0f) {
            this.fIZ.mNavigationBar.setY(0.0f);
        }
        z = this.fIZ.fIT;
        if (!z) {
            i6 = this.fIZ.fIJ;
            if (i6 <= i) {
                if (this.fIZ.fIM.getTop() <= this.fIZ.mNavigationBar.getHeight() && this.fIZ.fIM.getTop() > 0) {
                    this.fIZ.mNavigationBar.setY(this.fIZ.fIM.getTop() - this.fIZ.mNavigationBar.getHeight());
                }
                int top = this.fIZ.fIM.getTop();
                i7 = this.fIZ.fIY;
                if (top < i7) {
                    this.fIZ.acT();
                    this.fIZ.fIT = true;
                }
            }
        }
        z2 = this.fIZ.fIT;
        if (z2) {
            i4 = this.fIZ.fIJ;
            if (i4 >= i) {
                int top2 = this.fIZ.fIM.getTop();
                i5 = this.fIZ.fIY;
                if (top2 > i5) {
                    this.fIZ.aQf();
                    this.fIZ.fIT = false;
                }
            }
        }
        this.fIZ.fIJ = i;
    }
}
