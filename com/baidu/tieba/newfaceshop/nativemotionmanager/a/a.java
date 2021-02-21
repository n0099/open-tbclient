package com.baidu.tieba.newfaceshop.nativemotionmanager.a;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tbadk.widget.dragsort.a;
import com.baidu.tbadk.widget.dragsort.b;
/* loaded from: classes9.dex */
public class a {
    private final com.baidu.tbadk.widget.dragsort.a fRR;
    private final SimpleDragSortListView lDf;
    private final C0812a lDg;

    public a(SimpleDragSortListView simpleDragSortListView) {
        this.lDf = simpleDragSortListView;
        this.fRR = new com.baidu.tbadk.widget.dragsort.a(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        simpleDragSortListView.setDragSortViewEventDelegate(this.fRR);
        this.lDg = new C0812a(this.fRR, simpleDragSortListView);
        this.lDg.setBackgroundColor(-1);
        this.fRR.a((b) this.lDg);
        this.fRR.a((a.h) this.lDg);
        simpleDragSortListView.setOnTouchListener(this.lDg);
    }

    public void uv(boolean z) {
        this.fRR.setDragEnabled(z);
    }

    public void a(a.g gVar) {
        this.fRR.a(gVar);
    }

    public void cW(int i, int i2) {
        this.lDg.cX(i, i2);
    }

    /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0812a extends b {
        private ListView baj;
        private com.baidu.tbadk.widget.dragsort.a fRR;
        private int lDh;
        private int lDi;

        public C0812a(com.baidu.tbadk.widget.dragsort.a aVar, ListView listView) {
            super(aVar, listView, 0, 2, 0);
            this.lDh = 0;
            this.lDi = Integer.MAX_VALUE;
            lF(false);
            this.baj = listView;
            this.fRR = aVar;
        }

        public void cX(int i, int i2) {
            this.lDh = i;
            this.lDi = i2;
        }

        @Override // com.baidu.tbadk.widget.dragsort.b
        public int H(MotionEvent motionEvent) {
            int J = super.J(motionEvent);
            int headerViewsCount = J - this.baj.getHeaderViewsCount();
            if (headerViewsCount < this.lDh || headerViewsCount >= this.lDi) {
                return -1;
            }
            return J;
        }

        @Override // com.baidu.tbadk.widget.dragsort.b, com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
        public void b(View view, Point point, Point point2) {
            int top;
            int top2;
            View view2 = null;
            int firstVisiblePosition = this.baj.getFirstVisiblePosition();
            int dividerHeight = this.baj.getDividerHeight();
            int headerViewsCount = (this.lDh - firstVisiblePosition) + this.baj.getHeaderViewsCount();
            int headerViewsCount2 = this.baj.getHeaderViewsCount() + (this.lDi - firstVisiblePosition);
            int childCount = this.baj.getChildCount();
            View childAt = (headerViewsCount < 0 || headerViewsCount >= childCount) ? null : this.baj.getChildAt(headerViewsCount);
            if (headerViewsCount2 >= 0 && headerViewsCount2 < childCount) {
                view2 = this.baj.getChildAt(headerViewsCount2);
            }
            if (childAt != null && point.y < (top2 = childAt.getTop())) {
                point.y = top2;
            }
            if (view2 != null && point.y > (top = (view2.getTop() - dividerHeight) - view.getHeight())) {
                point.y = top;
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
        public void bW(View view) {
        }
    }
}
