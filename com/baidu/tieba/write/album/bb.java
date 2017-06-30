package com.baidu.tieba.write.album;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.write.album.TransparentHeadGridView;
/* loaded from: classes.dex */
class bb implements AbsListView.OnScrollListener {
    final /* synthetic */ TransparentHeadGridView ggE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(TransparentHeadGridView transparentHeadGridView) {
        this.ggE = transparentHeadGridView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener;
        AbsListView.OnScrollListener onScrollListener2;
        onScrollListener = this.ggE.ggB;
        if (onScrollListener != null) {
            onScrollListener2 = this.ggE.ggB;
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
            aVar = this.ggE.ggf;
            if (aVar != null) {
                i4 = this.ggE.ggC;
                if (i4 != 100 && this.ggE.getPaddingTop() == 0) {
                    aVar2 = this.ggE.ggf;
                    aVar2.tH(100);
                    this.ggE.ggC = 100;
                }
            }
        } else {
            View childAt = absListView.getChildAt(0);
            i5 = this.ggE.ggv;
            if (i5 < 0) {
                this.ggE.ggv = childAt.getTop();
            }
            int top = childAt.getTop();
            i6 = this.ggE.ggv;
            int i8 = -(top - i6);
            this.ggE.ggu = i8 == 0;
            view = this.ggE.ggw;
            if (view != null) {
                view2 = this.ggE.ggw;
                view2.scrollTo(0, i8);
            }
            aVar3 = this.ggE.ggf;
            if (aVar3 != null && childAt.getHeight() != 0 && this.ggE.getPaddingTop() == 0) {
                int height = (((int) (-childAt.getY())) * 100) / childAt.getHeight();
                i7 = this.ggE.ggC;
                if (height != i7) {
                    aVar4 = this.ggE.ggf;
                    aVar4.tH(height);
                    this.ggE.ggC = height;
                }
            }
        }
        onScrollListener = this.ggE.ggB;
        if (onScrollListener != null) {
            onScrollListener2 = this.ggE.ggB;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
    }
}
