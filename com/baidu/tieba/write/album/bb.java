package com.baidu.tieba.write.album;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.write.album.TransparentHeadGridView;
/* loaded from: classes.dex */
class bb implements AbsListView.OnScrollListener {
    final /* synthetic */ TransparentHeadGridView fOm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(TransparentHeadGridView transparentHeadGridView) {
        this.fOm = transparentHeadGridView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener;
        AbsListView.OnScrollListener onScrollListener2;
        onScrollListener = this.fOm.fOj;
        if (onScrollListener != null) {
            onScrollListener2 = this.fOm.fOj;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        TransparentHeadGridView.a aVar;
        int i4;
        TransparentHeadGridView.a aVar2;
        AbsListView.OnScrollListener onScrollListener;
        AbsListView.OnScrollListener onScrollListener2;
        int i5;
        int i6;
        View view;
        TransparentHeadGridView.a aVar3;
        int i7;
        TransparentHeadGridView.a aVar4;
        View view2;
        if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
            aVar = this.fOm.fNN;
            if (aVar != null) {
                i4 = this.fOm.fOk;
                if (i4 != 100 && this.fOm.getPaddingTop() == 0) {
                    aVar2 = this.fOm.fNN;
                    aVar2.sR(100);
                    this.fOm.fOk = 100;
                }
            }
        } else {
            View childAt = absListView.getChildAt(0);
            i5 = this.fOm.fOd;
            if (i5 < 0) {
                this.fOm.fOd = childAt.getTop();
            }
            int top = childAt.getTop();
            i6 = this.fOm.fOd;
            int i8 = -(top - i6);
            this.fOm.fOc = i8 == 0;
            view = this.fOm.fOe;
            if (view != null) {
                view2 = this.fOm.fOe;
                view2.scrollTo(0, i8);
            }
            aVar3 = this.fOm.fNN;
            if (aVar3 != null && childAt.getHeight() != 0 && this.fOm.getPaddingTop() == 0) {
                int height = (((int) (-childAt.getY())) * 100) / childAt.getHeight();
                i7 = this.fOm.fOk;
                if (height != i7) {
                    aVar4 = this.fOm.fNN;
                    aVar4.sR(height);
                    this.fOm.fOk = height;
                }
            }
        }
        onScrollListener = this.fOm.fOj;
        if (onScrollListener != null) {
            onScrollListener2 = this.fOm.fOj;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
    }
}
