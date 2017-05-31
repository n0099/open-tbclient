package com.baidu.tieba.write.album;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.write.album.TransparentHeadGridView;
/* loaded from: classes.dex */
class bb implements AbsListView.OnScrollListener {
    final /* synthetic */ TransparentHeadGridView fVT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(TransparentHeadGridView transparentHeadGridView) {
        this.fVT = transparentHeadGridView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener;
        AbsListView.OnScrollListener onScrollListener2;
        onScrollListener = this.fVT.fVQ;
        if (onScrollListener != null) {
            onScrollListener2 = this.fVT.fVQ;
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
            aVar = this.fVT.fVu;
            if (aVar != null) {
                i4 = this.fVT.fVR;
                if (i4 != 100 && this.fVT.getPaddingTop() == 0) {
                    aVar2 = this.fVT.fVu;
                    aVar2.tm(100);
                    this.fVT.fVR = 100;
                }
            }
        } else {
            View childAt = absListView.getChildAt(0);
            i5 = this.fVT.fVK;
            if (i5 < 0) {
                this.fVT.fVK = childAt.getTop();
            }
            int top = childAt.getTop();
            i6 = this.fVT.fVK;
            int i8 = -(top - i6);
            this.fVT.fVJ = i8 == 0;
            view = this.fVT.fVL;
            if (view != null) {
                view2 = this.fVT.fVL;
                view2.scrollTo(0, i8);
            }
            aVar3 = this.fVT.fVu;
            if (aVar3 != null && childAt.getHeight() != 0 && this.fVT.getPaddingTop() == 0) {
                int height = (((int) (-childAt.getY())) * 100) / childAt.getHeight();
                i7 = this.fVT.fVR;
                if (height != i7) {
                    aVar4 = this.fVT.fVu;
                    aVar4.tm(height);
                    this.fVT.fVR = height;
                }
            }
        }
        onScrollListener = this.fVT.fVQ;
        if (onScrollListener != null) {
            onScrollListener2 = this.fVT.fVQ;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
    }
}
