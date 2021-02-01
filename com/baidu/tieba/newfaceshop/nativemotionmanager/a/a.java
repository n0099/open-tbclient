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
    private final SimpleDragSortListView lCR;
    private final C0811a lCS;

    public a(SimpleDragSortListView simpleDragSortListView) {
        this.lCR = simpleDragSortListView;
        this.fRR = new com.baidu.tbadk.widget.dragsort.a(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        simpleDragSortListView.setDragSortViewEventDelegate(this.fRR);
        this.lCS = new C0811a(this.fRR, simpleDragSortListView);
        this.lCS.setBackgroundColor(-1);
        this.fRR.a((b) this.lCS);
        this.fRR.a((a.h) this.lCS);
        simpleDragSortListView.setOnTouchListener(this.lCS);
    }

    public void uv(boolean z) {
        this.fRR.setDragEnabled(z);
    }

    public void a(a.g gVar) {
        this.fRR.a(gVar);
    }

    public void cV(int i, int i2) {
        this.lCS.cW(i, i2);
    }

    /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0811a extends b {
        private ListView baj;
        private com.baidu.tbadk.widget.dragsort.a fRR;
        private int lCT;
        private int lCU;

        public C0811a(com.baidu.tbadk.widget.dragsort.a aVar, ListView listView) {
            super(aVar, listView, 0, 2, 0);
            this.lCT = 0;
            this.lCU = Integer.MAX_VALUE;
            lF(false);
            this.baj = listView;
            this.fRR = aVar;
        }

        public void cW(int i, int i2) {
            this.lCT = i;
            this.lCU = i2;
        }

        @Override // com.baidu.tbadk.widget.dragsort.b
        public int H(MotionEvent motionEvent) {
            int J = super.J(motionEvent);
            int headerViewsCount = J - this.baj.getHeaderViewsCount();
            if (headerViewsCount < this.lCT || headerViewsCount >= this.lCU) {
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
            int headerViewsCount = (this.lCT - firstVisiblePosition) + this.baj.getHeaderViewsCount();
            int headerViewsCount2 = this.baj.getHeaderViewsCount() + (this.lCU - firstVisiblePosition);
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
